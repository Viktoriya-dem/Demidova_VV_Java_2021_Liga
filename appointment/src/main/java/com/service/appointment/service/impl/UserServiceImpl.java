package com.service.appointment.service.impl;

import com.service.appointment.dto.ApiUserDto;
import com.service.appointment.entity.ApiUser;
import com.service.appointment.entity.Reserve;
import com.service.appointment.entity.Role;
import com.service.appointment.exception.UserNotFoundException;
import com.service.appointment.repo.ApiUserRepo;
import com.service.appointment.repo.RoleRepo;
import com.service.appointment.service.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {

    private final ApiUserRepo apiUserRepo;

    private final RoleRepo roleRepo;

    private final ModelMapper modelMapper;

    private final PasswordEncoder passwordEncoder;

    @Override
    public List<ApiUserDto> getAllUsers() {
        List<ApiUser> apiUsers = apiUserRepo.findAll();
        List<ApiUserDto> apiUserDtos = new ArrayList<>();
        for (ApiUser apiUser : apiUsers) {
            ApiUserDto mapUser = modelMapper.map(apiUser, ApiUserDto.class);
            apiUserDtos.add(mapUser);
        }
        return apiUserDtos;
    }

    @Transactional
    @Override
    public void saveUser(ApiUserDto apiUserDto) {
        ApiUser apiUser = modelMapper.map(apiUserDto, ApiUser.class);
        apiUser.setPassword(passwordEncoder.encode(apiUser.getPassword()));
        Role role=roleRepo.findById(2);
        apiUser.setRole(role);
        apiUserRepo.save(apiUser);
    }

    @Override
    public ApiUserDto getUserById(int id) {
        ApiUserDto apiUserDto = null;
        Optional<ApiUser> optional = apiUserRepo.findById(id);
        if (optional.isPresent()) {
            apiUserDto = modelMapper.map(optional.get(), ApiUserDto.class);
        } else throw new UserNotFoundException();
        return apiUserDto;
    }

    @Override
    public ApiUserDto getUser(String username) {
        ApiUser apiUser = apiUserRepo.findByUsername(username);
        if (apiUser==null) throw new UserNotFoundException();
        ApiUserDto apiUserDto = modelMapper.map(apiUser, ApiUserDto.class);
        return apiUserDto;
    }

    @Override
    public void deleteUser(int id) {
    apiUserRepo.findById(id).orElseThrow(UserNotFoundException::new);
        apiUserRepo.deleteById(id);
    }

    @Override
    public void saveRole(Role role) {
        roleRepo.save(role);
    }

    @Override
    public Role findById(int id){
        return roleRepo.findById(id);
    }

    @Transactional
    @Override
    public void addRoleToUser(String username, String roleName) {
        ApiUser apiUser = apiUserRepo.findByUsername(username);
        //if (apiUser==null) throw new UserNotFoundException();
        Role role = roleRepo.findByName(roleName);
        apiUser.setRole(role);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        ApiUser apiUser = apiUserRepo.findByUsername(username);
        if (apiUser == null) {
            log.error("User not found in the Database");
            throw new UsernameNotFoundException("User not found");
        } else {
            log.info("User found in the Database: {}", username);
        }

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(apiUser.getRole().getName()));

        System.out.println(apiUser.getRole().getName()+ "loadByUserName userserviceImpl");

        return new org.springframework.security.core.userdetails.User(
                apiUser.getUsername(), apiUser.getPassword(), authorities
        );
    }
}

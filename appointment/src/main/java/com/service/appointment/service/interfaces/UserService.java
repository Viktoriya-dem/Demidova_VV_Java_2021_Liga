package com.service.appointment.service.interfaces;

import com.service.appointment.dto.ApiUserDto;
import com.service.appointment.entity.ApiUser;
import com.service.appointment.entity.Role;

import java.util.List;

public interface UserService {

    List<ApiUserDto> getAllUsers();
    void saveUser(ApiUserDto user);
    ApiUserDto getUserById(int id);
    ApiUserDto getUser(String username);
    void deleteUser(int id);
    void saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    Role findById(int id);

}


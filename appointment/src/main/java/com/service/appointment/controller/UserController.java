package com.service.appointment.controller;

import com.service.appointment.dto.ApiUserDto;
import com.service.appointment.entity.ApiUser;
import com.service.appointment.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl apiUserService;

    @DeleteMapping("/admin/delete/user/{id}")
    public void deleteUser(@PathVariable int id) {
    ApiUserDto apiUserDto=apiUserService.getUserById(id);
    apiUserService.deleteUser(id);
    }

    @Transactional
    @PostMapping("/register")
    public void registerUser(@RequestBody ApiUserDto apiUserDto) {
        apiUserService.saveUser(apiUserDto);
    }


}

package com.service.appointment.controller;

import com.service.appointment.dto.ApiUserDto;
import com.service.appointment.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl apiUserService;

    @DeleteMapping("/admin/{id}")
    public void deleteUser(@PathVariable int id) {
    ApiUserDto apiUserDto=apiUserService.getUserById(id);
    apiUserService.deleteUser(id);
    }

    @PostMapping("/register")
    public void registerUser(@RequestBody ApiUserDto apiUserDto) {
        apiUserService.saveUser(apiUserDto);
    }


}

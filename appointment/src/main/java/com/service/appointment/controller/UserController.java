package com.service.appointment.controller;

import com.service.appointment.dto.ApiUserDto;
import com.service.appointment.service.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Api(value = "Register/delete user operations", description = "Register/delete user operations")
public class UserController {

    private final UserServiceImpl apiUserService;

    @ApiOperation(value = "Delete user for admin")
    @DeleteMapping("/admin/{id}")
    public void deleteUser(@PathVariable int id) {
    ApiUserDto apiUserDto=apiUserService.getUserById(id);
    apiUserService.deleteUser(id);
    }

    @ApiOperation(value = "Register for user")
    @PostMapping("/register")
    public void registerUser(@RequestBody ApiUserDto apiUserDto) {
        apiUserService.saveUser(apiUserDto);
    }


}

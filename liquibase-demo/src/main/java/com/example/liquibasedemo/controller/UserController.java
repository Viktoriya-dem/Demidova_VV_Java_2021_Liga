package com.example.liquibasedemo.controller;

import com.example.liquibasedemo.entity.Post;
import com.example.liquibasedemo.entity.School;
import com.example.liquibasedemo.entity.User;
import com.example.liquibasedemo.service.SchoolService;
import com.example.liquibasedemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final SchoolService schoolService;

    @Autowired
    public UserController(UserService userService, SchoolService schoolService) {
        this.userService = userService;
        this.schoolService = schoolService;
    }


    @RequestMapping(value = "/show-users", method = RequestMethod.GET)
    public String findAll() {
        StringBuilder builder = new StringBuilder();
        for (User user : userService.findAll()) {
            builder.append(user.toString()+"\n");
        }
        return builder.toString();
    }

    @RequestMapping(value = "/show-users/{id}", method = RequestMethod.GET)
    public String finById(@PathVariable("id") Integer id) {
        return userService.findById(id).toString();
    }

    @RequestMapping(value = "/create/{name}/{age}/{gender}/{school_id}", method = RequestMethod.POST)
    public String createUser(@PathVariable("name") String name, @PathVariable("age") int age,
                             @PathVariable("gender") String gender,
                             @PathVariable("school_id") Integer school_id) {
        School school = schoolService.findById(school_id);
        User user = new User(name, age, gender, school);
        userService.saveUser(user);
        return "redirect:/users";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
    public String deleteUser(@PathVariable("id") Integer id) {
        userService.deleteById(id);
        return "redirect:/users";
    }
    
    @RequestMapping(value = "/update/{id}/{name}/{age}/{gender}/{school_id}", method = RequestMethod.POST)
    public String updateUser(@PathVariable("id") Integer id, @PathVariable("name") String name,
                             @PathVariable("age") int age, @PathVariable("gender") String gender,
                             @PathVariable("school_id") Integer school_id) {
        School school = schoolService.findById(school_id);
        User user = userService.findById(id);
        user.setName(name);
        user.setAge(age);
        user.setGender(gender);
        user.setSchool_id(school);
        userService.saveUser(user);
        return "redirect:/users";
    }

    @RequestMapping(value = "/add-friend/{user_id}/{user2_id}", method = RequestMethod.POST)
    public String addFriend(@PathVariable("user_id") Integer user_id, @PathVariable("user2_id") Integer user2_id) {
        User user = userService.findById(user_id);
        User user2 = userService.findById(user2_id);
        user.addFriend(user2);
        user2.addFriend(user);
        userService.saveUser(user);
        userService.saveUser(user2);
        return "redirect:/userFriends";
    }

    @RequestMapping(value = "/delete-friend/{user_id}/{user2_id}", method = RequestMethod.POST)
    public String deleteFriend(@PathVariable("user_id") Integer user_id, @PathVariable("user2_id") Integer user2_id) {
        User user = userService.findById(user_id);
        User user2 = userService.findById(user2_id);
        user.deleteFriend(user2);
        user2.deleteFriend(user);
        userService.saveUser(user);
        userService.saveUser(user2);
        return "redirect:/userFriends";
    }

    @RequestMapping(value = "/show-posts/{id}", method = RequestMethod.GET)
    public String findPosts(@PathVariable("id") Integer id) {
        User user = userService.findById(id);
        StringBuilder builder = new StringBuilder();
        for (Post post : user.getPostList()) {
            builder.append(post.toString() + "\n");
        }
        return builder.toString();
    }

    @RequestMapping(value = "/show-friends/{id}", method = RequestMethod.GET)
    public String findFriends(@PathVariable("id") Integer id) {
        User user = userService.findById(id);
        StringBuilder builder = new StringBuilder();
        for (User user1 : user.getFriends()) {
            builder.append(user1.toString() + "\n");
        }
        return builder.toString();
    }

}

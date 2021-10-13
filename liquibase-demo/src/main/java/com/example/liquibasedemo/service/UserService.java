package com.example.liquibasedemo.service;

import com.example.liquibasedemo.entity.School;
import com.example.liquibasedemo.entity.User;
import com.example.liquibasedemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final SchoolService schoolService;

    @Autowired
    public UserService(UserRepository userRepository, SchoolService schoolService) {
        this.userRepository = userRepository;
        this.schoolService = schoolService;
    }

    public User findById(int id) {
        return userRepository.getById(id);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    public User updateUser(Integer id, String name, int age, String gender, Integer school_id) {
        School school = schoolService.findById(school_id);
        User user = findById(id);
        user.setName(name);
        user.setAge(age);
        user.setGender(gender);
        user.setSchool_id(school);
        return user;
    }

    public User createUser(String name, int age, String gender, Integer school_id) {
        School school = schoolService.findById(school_id);
        User user = new User(name, age, gender, school);
        return user;
    }
}

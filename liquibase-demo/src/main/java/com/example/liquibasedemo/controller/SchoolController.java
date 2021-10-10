package com.example.liquibasedemo.controller;

import com.example.liquibasedemo.entity.School;
import com.example.liquibasedemo.entity.User;
import com.example.liquibasedemo.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/school")
public class SchoolController {

    private final SchoolService schoolService;

    @Autowired
    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @RequestMapping(value = "/show-schools", method = RequestMethod.GET)
    public String findAll() {
        StringBuilder builder = new StringBuilder();
        for (School school : schoolService.findAll()) {
            builder.append(school.toString() + "\n");
        }
        return builder.toString();
    }

    @RequestMapping(value = "/show-schools/{id}", method = RequestMethod.GET)
    public String findById(@PathVariable("id") Integer id) {
        return schoolService.findById(id).toString();
    }

    @RequestMapping(value = "/create/{title}/{address}", method = RequestMethod.POST)
    public String createSchool(@PathVariable("title") String title, @PathVariable("address") String address) {
        School school = new School(title, address);
        schoolService.saveSchool(school);
        return "redirect:/show-schools";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
    public String deleteSchool(@PathVariable("id") Integer id) {
        schoolService.deleteById(id);
        return "redirect:/show-schools";
    }

    @RequestMapping(value = "/update/{id}/{title}/{address}", method = RequestMethod.POST)
    public String updateSchool(@PathVariable("id") Integer id, @PathVariable("title") String title, @PathVariable("address") String address) {
        School school = schoolService.findById(id);
        school.setTitle(title);
        school.setAddress(address);
        schoolService.saveSchool(school);
        return "redirect:/show-schools";
    }

    @RequestMapping(value = "/show-students/{id}", method = RequestMethod.GET)
    public String findStudents(@PathVariable("id") Integer id) {
        School school = schoolService.findById(id);
        StringBuilder builder = new StringBuilder();
        for (User user : school.getUserList()) {
            builder.append(user.toString() + "\n");
        }
        return builder.toString();
    }

}


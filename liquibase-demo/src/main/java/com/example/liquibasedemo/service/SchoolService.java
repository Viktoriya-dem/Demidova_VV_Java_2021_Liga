package com.example.liquibasedemo.service;

import com.example.liquibasedemo.entity.School;
import com.example.liquibasedemo.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {

    private final SchoolRepository schoolRepository;

    @Autowired
    public SchoolService(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    public School findById(int id) {
        return schoolRepository.getById(id);
    }

    public List<School> findAll() {
        return schoolRepository.findAll();
    }

    public School saveSchool(School school) {
        return schoolRepository.save(school);
    }

    public void deleteById(int id) {
        schoolRepository.deleteById(id);
    }
}

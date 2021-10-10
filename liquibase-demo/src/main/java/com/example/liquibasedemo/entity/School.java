package com.example.liquibasedemo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "school")
@Getter
@Setter
public class School {
    public School() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Integer id;

    @Column(name = "title", length = 100, unique = true)
    private String title;

    @Column(name = "address", length = 100)
    private String address;

    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.PERSIST,
            CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "school_id")
    private List<User> userList;

    public School(String title, String address) {
        this.title = title;
        this.address = address;
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

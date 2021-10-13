package com.example.liquibasedemo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "users")
@Getter
@Setter
@Validated
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Integer id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "gender", length = 1)
    @Pattern(message = "Неправильно введен пол", regexp = "[MF]")
    private String gender;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.PERSIST,
            CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "school_id")
    private School school_id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<Post> postList;

    @ManyToMany
    @JoinTable(name = "friends",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "user2_id")
    )
    private List<User> friends;

    public User() {
    }

    public User(String name, int age, String gender, School school) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.school_id = school;
    }

    public User(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.school_id = null;
    }

    public void addFriend(User user) {
        if (this.getFriends() == null) {
            this.setFriends(new ArrayList<>());
        }
        this.getFriends().add(user);
    }

    public void deleteFriend(User user) {
        if (this.getFriends().contains(user)) {
            this.getFriends().remove(user);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", school_title='" + school_id.getTitle() +
                '}';
    }

    public String toStringSchool() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender +
                '}';
    }
}


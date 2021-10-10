package com.example.liquibasedemo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "post")
@Getter
@Setter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Integer id;

    @Column(name = "content", length = 2048)
    private String content;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.PERSIST,
            CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    private User user;

    public Post() {
    }

    public Post(String content, User user) {
        this.content = content;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", user=" + user.getName() +
                '}';
    }
}

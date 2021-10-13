package com.example.liquibasedemo.service;

import com.example.liquibasedemo.entity.Post;
import com.example.liquibasedemo.entity.User;
import com.example.liquibasedemo.repository.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final UserService userService;

    @Autowired
    public PostService(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }

    public Post findById(int id) {
        return postRepository.getById(id);
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    public Post createPost(String content, Integer user_id) {
        User user = userService.findById(user_id);
        Post post = new Post(content, user);
        return post;
    }

    public void deleteById(int id) {
        postRepository.deleteById(id);
    }
}

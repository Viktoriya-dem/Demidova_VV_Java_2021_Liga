package com.example.liquibasedemo.service;

import com.example.liquibasedemo.entity.Post;
import com.example.liquibasedemo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
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

    public void deleteById(int id) {
        postRepository.deleteById(id);
    }
}

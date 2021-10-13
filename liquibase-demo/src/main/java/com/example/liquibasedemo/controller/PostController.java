package com.example.liquibasedemo.controller;

import com.example.liquibasedemo.entity.Post;
import com.example.liquibasedemo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/post")
public class PostController {

    private final PostService postService;


    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @RequestMapping(value = "/show-posts", method = RequestMethod.GET)
    public String findAll() {
        StringBuilder builder = new StringBuilder();
        for (Post post : postService.findAll()) {
            builder.append(post.toString() + "\n");
        }
        return builder.toString();
    }

    @RequestMapping(value = "/show-posts/{id}", method = RequestMethod.GET)
    public String findById(@PathVariable("id") Integer id) {
        return postService.findById(id).toString();
    }


    @RequestMapping(value = "/create/{content}/{user_id}", method = RequestMethod.POST)
    public String createPost(@PathVariable("content") String content, @PathVariable("user_id") Integer user_id) {
        Post post = postService.createPost(content, user_id);
        postService.savePost(post);
        return "redirect:/post";
    }


    @RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
    public String deletePost(@PathVariable("id") Integer id) {
        postService.deleteById(id);
        return "redirect:/post";
    }


    @RequestMapping(value = "/update/{id}/{content}", method = RequestMethod.POST)
    public String updatePost(@PathVariable("id") Integer id, @PathVariable("content") String content) {
        Post post = postService.findById(id);
        post.setContent(content);
        postService.savePost(post);
        return "redirect:/post";
    }
}

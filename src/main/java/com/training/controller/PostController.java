package com.training.controller;

import com.training.consts.ApiPath;
import com.training.dto.PostDTO;
import com.training.repository.PostRepository;
import com.training.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    PostService service;

    @PostMapping(value = ApiPath.POST_CREATE)
    public PostDTO newPost(@RequestBody PostDTO newPost) {
        return service.save(newPost);
    }

    @GetMapping(value = ApiPath.POST_GET_ALL)
    public List<PostDTO> getAllPosts() {
        return service.findAll();
    }

    @GetMapping(value = ApiPath.POST_BY_ID)
    public PostDTO getPostById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping(value = ApiPath.POST_UPDATE)
    public Integer updatePost(@RequestBody PostDTO newPost) {
        return service.update(newPost);
    }

    @DeleteMapping(value = ApiPath.POST_DELETE)
    public String deletePost(@RequestBody PostDTO newPost) {
        boolean isDelete = service.delete(newPost);
        return  isDelete ? "Delete success!!!" : "Delete fail!!!";
    }
}

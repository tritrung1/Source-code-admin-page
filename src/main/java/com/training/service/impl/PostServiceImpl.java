package com.training.service.impl;

import com.training.dto.PostDTO;
import com.training.entity.Post;
import com.training.mapper.PostMapper;
import com.training.repository.PostRepository;
import com.training.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostRepository postRepository;

    @Autowired
    PostMapper postMapper;
    @Override
    public List<PostDTO> findAll() {
        List<Post> posts = postRepository.findAll();
        return posts == null || posts.size() == 0 ? new ArrayList<>()
                : posts.stream().map(item -> postMapper.convertEntityToDTO(item))
                .collect(Collectors.toList());
    }

    @Override
    public PostDTO findById(Long id) {
        Optional<Post> post = postRepository.findById(id);
        return post != null && post.isPresent() ? postMapper.convertEntityToDTO(post.get())
                : new PostDTO();
    }

    @Override
    public PostDTO save(PostDTO postDTO) {
        if (postDTO == null) return new PostDTO();
        Post post = postRepository.save(postMapper.convertDTOToEntity(postDTO));
        return post == null ? new PostDTO() : postMapper.convertEntityToDTO(post);
    }

    @Override
    public int update(PostDTO postDTO) {
        if (postDTO == null || postDTO.getId() == null) return -1;
        Optional<Post> post = postRepository.findById(postDTO.getId());
        if (post != null && post.isPresent()) {
            //update
            Post postUpdate = postRepository.save(postMapper.convertDTOToEntity(postDTO));
            return postUpdate == null ? 0 : 1;
        }
        return -1;
    }

    @Override
    public boolean delete(PostDTO postDTO) {
        try {
            if (postDTO == null || postDTO.getId() == null) return false;
            Optional<Post> post = postRepository.findById(postDTO.getId());
            if (post != null && post.isPresent()) {
                //delete
                postRepository.delete(post.get());
                return true;
            }
            return false;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}

package com.training.mapper;

import com.training.dto.PostDTO;
import com.training.entity.Post;
import org.springframework.stereotype.Service;

@Service
public class PostMapper extends AbstractMapper<Post, PostDTO> {
    public PostMapper() {
        super(Post.class, PostDTO.class);
    }
}
package com.training.service;

import com.training.dto.PostDTO;
import com.training.entity.Post;

import java.util.List;

public interface PostService extends BaseService<PostDTO> {
    List<PostDTO> findByStatusEqualsIgnoreCase();
}


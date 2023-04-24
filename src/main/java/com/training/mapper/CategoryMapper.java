package com.training.mapper;

import com.training.dto.CategoryDTO;
import com.training.entity.Category;
import org.springframework.stereotype.Service;

@Service
public class CategoryMapper extends AbstractMapper<Category, CategoryDTO> {
    public CategoryMapper() {
        super(Category.class, CategoryDTO.class);
    }
}

package com.training.service.impl;

import com.fasterxml.uuid.Generators;
import com.training.dto.CategoryDTO;
import com.training.entity.Category;
import com.training.mapper.CategoryMapper;
import com.training.repository.CategoryRepository;
import com.training.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<CategoryDTO> findAll() {
        List<Category> categories = categoryRepository.findAll();
        return categories == null || categories.size() == 0 ? new ArrayList<>()
                : categories.stream().map(item -> categoryMapper.convertEntityToDTO(item))
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO findById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category != null && category.isPresent() ? categoryMapper.convertEntityToDTO(category.get())
                : new CategoryDTO();
    }

    @Override
    public CategoryDTO save(CategoryDTO categoryDTO) {
        if (categoryDTO == null) return new CategoryDTO();
        // get unique uuid
        UUID uuid = Generators.timeBasedGenerator().generate();

        // set field or data for generate UUID
        categoryDTO.setCategoryUuid(uuid.toString());

        Category category = categoryRepository.save(categoryMapper.convertDTOToEntity(categoryDTO));
        return category == null ? new CategoryDTO() : categoryMapper.convertEntityToDTO(category);
    }

    @Override
    public int update(CategoryDTO categoryDTO) {
        if (categoryDTO == null || categoryDTO.getId() == null) return -1;
        Optional<Category> category = categoryRepository.findById(categoryDTO.getId());
        if (category != null && category.isPresent()) {
            //update
            Category categoryUpdate = categoryRepository.save(categoryMapper.convertDTOToEntity(categoryDTO));
            return categoryUpdate == null ? 0 : 1;
        }
        return -1;
    }

    @Override
    public boolean delete(CategoryDTO categoryDTO) {
        try {
            if (categoryDTO == null || categoryDTO.getId() == null) return false;
            Optional<Category> category = categoryRepository.findById(categoryDTO.getId());
            if (category != null && category.isPresent()) {
                //delete
                categoryRepository.delete(category.get());
                return true;
            }
            return false;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}

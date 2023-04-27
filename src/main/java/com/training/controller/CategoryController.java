package com.training.controller;

import com.training.consts.ApiPath;
import com.training.dto.CategoryDTO;
import com.training.repository.CategoryRepository;
import com.training.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    CategoryService service;

    @PostMapping(value = ApiPath.CATEGORY_CREATE)
    public CategoryDTO newCategory(@RequestBody CategoryDTO newCategory) {
        return service.save(newCategory);
    }

    @GetMapping(value = ApiPath.CATEGORY_GET_ALL)
    public List<CategoryDTO> getAllCategorys() {
        return service.findAll();
    }

    @GetMapping(value = ApiPath.CATEGORY_BY_ID)
    public CategoryDTO getCategoryById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping(value = ApiPath.CATEGORY_UPDATE)
    public Integer updateCategory(@RequestBody CategoryDTO newCategory) {
        return service.update(newCategory);
    }

    @DeleteMapping(value = ApiPath.CATEGORY_DELETE)
    public String deleteCategory(@RequestBody CategoryDTO newCategory) {
        boolean isDelete = service.delete(newCategory);
        return  isDelete ? "Delete success!!!" : "Delete fail!!!";
    }
}

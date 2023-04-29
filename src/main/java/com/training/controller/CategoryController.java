package com.training.controller;

import com.training.consts.ApiPath;
import com.training.dto.CategoryDTO;
import com.training.repository.CategoryRepository;
import com.training.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class CategoryController {
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CategoryService service;

    @PostMapping(value = ApiPath.CATEGORY_CREATE)
    public ResponseEntity<CategoryDTO> create(CategoryDTO request) {
        try {
            CategoryDTO create = service.save(request);
            if (create == null ||null == request) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return new ResponseEntity<>(create, HttpStatus.OK);
        } catch (Exception ex) {
            log.error("Error when create category:", ex);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = ApiPath.CATEGORY_GET_ALL)
    public ResponseEntity<List<CategoryDTO>> getAll() {
        try {
            List<CategoryDTO> list = service.findAll();
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception ex) {
            log.error("Error when get all category:", ex);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
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

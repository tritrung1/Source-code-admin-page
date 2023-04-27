package com.training.controller;

import com.training.consts.ApiPath;
import com.training.dto.ProductDTO;
import com.training.repository.ProductRepository;
import com.training.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    ProductService service;

    @PostMapping(value = ApiPath.PRODUCT_CREATE)
    public ProductDTO newProduct(@RequestBody ProductDTO newProduct) {
        return service.save(newProduct);
    }

    @GetMapping(value = ApiPath.PRODUCT_GET_ALL)
    public List<ProductDTO> getAllProducts() {
        return service.findAll();
    }

    @GetMapping(value = ApiPath.PRODUCT_BY_ID)
    public ProductDTO getProductById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping(value = ApiPath.PRODUCT_UPDATE)
    public Integer updateProduct(@RequestBody ProductDTO newProduct) {
        return service.update(newProduct);
    }

    @DeleteMapping(value = ApiPath.PRODUCT_DELETE)
    public String deleteProduct(@RequestBody ProductDTO newProduct) {
        boolean isDelete = service.delete(newProduct);
        return  isDelete ? "Delete success!!!" : "Delete fail!!!";
    }
}

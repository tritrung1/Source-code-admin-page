package com.training.service;

import com.training.dto.ProductDTO;

import java.util.List;

public interface ProductService extends BaseService<ProductDTO>{
    List<ProductDTO> findAllByCategory(String categoryName);
}

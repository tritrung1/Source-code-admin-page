package com.training.service;

import com.training.dto.ProductDTO;
import com.training.entity.Product;

import java.util.List;

public interface ProductService extends BaseService<ProductDTO>{
    List<ProductDTO> findAllByCategory(String categoryName);

    public List<ProductDTO> findByAccount(String accountName);
}

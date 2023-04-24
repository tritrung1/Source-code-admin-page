package com.training.mapper;

import com.training.dto.ProductDTO;
import com.training.entity.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper extends AbstractMapper<Product, ProductDTO> {
    public ProductMapper() {
        super(Product.class, ProductDTO.class);
    }
}

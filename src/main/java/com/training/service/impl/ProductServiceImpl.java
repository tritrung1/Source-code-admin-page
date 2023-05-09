package com.training.service.impl;

import com.fasterxml.uuid.Generators;
import com.training.dto.ProductDTO;
import com.training.entity.Product;
import com.training.mapper.ProductMapper;
import com.training.repository.ProductRepository;
import com.training.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductMapper productMapper;
    @Override
    public List<ProductDTO> findAll() {
        List<Product> products = productRepository.findAll();
        return products == null || products.size() == 0 ? new ArrayList<>()
                : products.stream().map(item -> productMapper.convertEntityToDTO(item))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO findById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product != null && product.isPresent() ? productMapper.convertEntityToDTO(product.get())
                : new ProductDTO();
    }

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        if (productDTO == null) return new ProductDTO();
        // get unique uuid
        UUID uuid = Generators.timeBasedGenerator().generate();

        // set field or data for generate UUID
        productDTO.setProductUuid(uuid.toString());

        Product product = productRepository.save(productMapper.convertDTOToEntity(productDTO));
        return product == null ? new ProductDTO() : productMapper.convertEntityToDTO(product);
    }

    @Override
    public int update(ProductDTO productDTO) {
        if (productDTO == null || productDTO.getId() == null) return -1;
        Optional<Product> product = productRepository.findById(productDTO.getId());
        if (product != null && product.isPresent()) {
            //update
            Product productUpdate = productRepository.save(productMapper.convertDTOToEntity(productDTO));
            return productUpdate == null ? 0 : 1;
        }
        return -1;
    }

    @Override
    public boolean delete(ProductDTO productDTO) {
        try {
            if (productDTO == null || productDTO.getId() == null) return false;
            Optional<Product> product = productRepository.findById(productDTO.getId());
            if (product != null && product.isPresent()) {
                //delete
                productRepository.delete(product.get());
                return true;
            }
            return false;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<ProductDTO> findAllByCategory(String categoryName) {
        List<Product> product_by_category = productRepository.findAllByCategory_CategoryName(categoryName);
        return product_by_category == null || product_by_category.size() == 0 ? new ArrayList<>()
                : product_by_category.stream().map(item -> productMapper.convertEntityToDTO(item))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> findByAccount( String accountName) {
        List<Product> product_by_account = productRepository.findByAccount(accountName);
        return product_by_account == null || product_by_account.size() == 0 ? new ArrayList<>()
                : product_by_account.stream().map(item -> productMapper.convertEntityToDTO(item))
                .collect(Collectors.toList());
    }
}

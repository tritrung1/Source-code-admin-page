package com.training.repository;

import com.training.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>, CrudRepository<Product, Long> {
    List<Product> findAllByCategory_CategoryName(String categoryName);

    @Modifying
    @Query(value = "SELECT * FROM product p inner join account a WHERE p.account_name  = a.account_name AND p.account_name =:accountName ",nativeQuery = true)
    public List<Product> findByAccount(String accountName);
}

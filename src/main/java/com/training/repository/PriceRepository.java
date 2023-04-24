package com.training.repository;

import com.training.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<Price,Long>, CrudRepository<Price, Long> {
}

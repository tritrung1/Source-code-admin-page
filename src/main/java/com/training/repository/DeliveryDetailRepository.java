package com.training.repository;

import com.training.entity.DeliveryDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryDetailRepository extends JpaRepository<DeliveryDetail,Long>, CrudRepository<DeliveryDetail, Long> {
}

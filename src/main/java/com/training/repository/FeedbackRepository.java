package com.training.repository;

import com.training.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback,Long>, CrudRepository<Feedback, Long> {
    @Modifying
    @Query(value = "SELECT * FROM feedbacks f WHERE f.active = 1" , nativeQuery = true)
    List<Feedback> findByStatus();
}


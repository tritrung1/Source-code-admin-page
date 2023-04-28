package com.training.repository;
import com.training.entity.Feedback;
import com.training.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback,Long>, CrudRepository<Feedback, Long> {
}


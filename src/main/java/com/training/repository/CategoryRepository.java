package com.training.repository;

<<<<<<<< Updated upstream:src/main/java/com/training/repository/CategoryRepository.java
import com.training.entity.Category;
========
import com.training.entity.Feedback;

>>>>>>>> Stashed changes:src/main/java/com/training/repository/FeedbackRepository.java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
<<<<<<<< Updated upstream:src/main/java/com/training/repository/CategoryRepository.java
public interface CategoryRepository extends JpaRepository<Category,Long>, CrudRepository<Category, Long> {
========
public interface FeedbackRepository extends JpaRepository<Feedback,Long>, CrudRepository<Feedback, Long> {
>>>>>>>> Stashed changes:src/main/java/com/training/repository/FeedbackRepository.java
}

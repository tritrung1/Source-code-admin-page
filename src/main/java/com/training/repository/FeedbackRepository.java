package com.training.repository;

<<<<<<< Updated upstream
<<<<<<< Updated upstream
<<<<<<<< Updated upstream:src/main/java/com/training/repository/PostRepository.java
import com.training.entity.Post;
=======
<<<<<<<< Updated upstream:src/main/java/com/training/repository/CategoryRepository.java
import com.training.entity.Category;
>>>>>>> Stashed changes
=======
<<<<<<<< Updated upstream:src/main/java/com/training/repository/CustomerRepository.java
import com.training.entity.Customer;
>>>>>>> Stashed changes
========
import com.training.entity.Feedback;

>>>>>>>> Stashed changes:src/main/java/com/training/repository/FeedbackRepository.java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
<<<<<<< Updated upstream
<<<<<<< Updated upstream
<<<<<<<< Updated upstream:src/main/java/com/training/repository/PostRepository.java
public interface PostRepository extends JpaRepository<Post,Long>, CrudRepository<Post, Long> {
=======
<<<<<<<< Updated upstream:src/main/java/com/training/repository/CategoryRepository.java
public interface CategoryRepository extends JpaRepository<Category,Long>, CrudRepository<Category, Long> {
>>>>>>> Stashed changes
=======
<<<<<<<< Updated upstream:src/main/java/com/training/repository/CustomerRepository.java
public interface CustomerRepository extends JpaRepository<Customer,Long>, CrudRepository<Customer, Long> {
>>>>>>> Stashed changes
========
public interface FeedbackRepository extends JpaRepository<Feedback,Long>, CrudRepository<Feedback, Long> {
>>>>>>>> Stashed changes:src/main/java/com/training/repository/FeedbackRepository.java
}
<<<<<<< Updated upstream
<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes

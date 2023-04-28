package com.training.repository;

<<<<<<<< Updated upstream:src/main/java/com/training/repository/CustomerRepository.java
import com.training.entity.Customer;
========
import com.training.entity.Feedback;

>>>>>>>> Stashed changes:src/main/java/com/training/repository/FeedbackRepository.java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
<<<<<<<< Updated upstream:src/main/java/com/training/repository/CustomerRepository.java
public interface CustomerRepository extends JpaRepository<Customer,Long>, CrudRepository<Customer, Long> {
========
public interface FeedbackRepository extends JpaRepository<Feedback,Long>, CrudRepository<Feedback, Long> {
>>>>>>>> Stashed changes:src/main/java/com/training/repository/FeedbackRepository.java
}

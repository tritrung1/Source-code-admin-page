package com.training.repository;
import com.training.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Long>, CrudRepository<Post, Long> {
    @Modifying
    @Query(value = "select * from POST where status = 'pending'",nativeQuery = true)
    List<Post> findByStatusEqualsIgnoreCase();
}



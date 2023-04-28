package com.training.repository;

import com.training.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
<<<<<<< Updated upstream
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<Report,Long>, CrudRepository<Report, Long> {
=======

public interface ReportRepository extends JpaRepository<Report,Long>, CrudRepository<Report,Long> {
>>>>>>> Stashed changes
}

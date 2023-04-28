package com.training.mapper;

import com.training.dto.ReportDTO;
import com.training.entity.Report;
import org.springframework.stereotype.Service;

@Service
<<<<<<< Updated upstream
public class ReportMapper extends AbstractMapper<Report, ReportDTO> {
    public ReportMapper() {
        super(Report.class, ReportDTO.class);
=======
public class ReportMapper extends AbstractMapper<Report, ReportDTO>{
    public ReportMapper(){
    super(Report.class, ReportDTO.class);
>>>>>>> Stashed changes
    }
}

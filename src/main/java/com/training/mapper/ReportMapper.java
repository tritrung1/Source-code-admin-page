package com.training.mapper;

import com.training.dto.ReportDTO;
import com.training.entity.Report;
import org.springframework.stereotype.Service;

@Service
public class ReportMapper extends AbstractMapper<Report, ReportDTO> {
    public ReportMapper() {
        super(Report.class, ReportDTO.class);
    }
}

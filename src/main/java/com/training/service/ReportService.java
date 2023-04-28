package com.training.service;

import com.training.dto.ReportDTO;
import net.sf.jasperreports.engine.JRException;

import java.io.FileNotFoundException;

public interface ReportService extends BaseService<ReportDTO> {
    String exportReport(String reportType) throws FileNotFoundException , JRException;
}

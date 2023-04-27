package com.training.service.impl;

import com.training.dto.ReportDTO;
import com.training.entity.Report;
import com.training.mapper.ReportMapper;
import com.training.repository.ReportRepository;
import com.training.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    ReportRepository reportRepository;

    @Autowired
    ReportMapper reportMapper;

    @Override
    public List<ReportDTO> findAll() {
        List<Report> reports = reportRepository.findAll();
        return reports == null || reports.size() == 0 ? new ArrayList<>()
                : reports.stream().map(item -> reportMapper.convertEntityToDTO(item))
                .collect(Collectors.toList());
    }

    @Override
    public ReportDTO findById(Long id) {
        Optional<Report> report = reportRepository.findById(id);
        return report != null && report.isPresent() ? reportMapper.convertEntityToDTO(report.get())
                : new ReportDTO();
    }

    @Override
    public ReportDTO save(ReportDTO reportDTO) {
        if (reportDTO == null) return new ReportDTO();
        Report report = reportRepository.save(reportMapper.convertDTOToEntity(reportDTO));
        return report == null ? new ReportDTO() : reportMapper.convertEntityToDTO(report);
    }

    @Override
    public int update(ReportDTO reportDTO) {
        if (reportDTO == null || reportDTO.getId() == null) return -1;
        Optional<Report> report = reportRepository.findById(reportDTO.getId());
        if (report != null && report.isPresent()) {
            //update
            Report reportUpdate = reportRepository.save(reportMapper.convertDTOToEntity(reportDTO));
            return reportUpdate == null ? 0 : 1;
        }
        return -1;
    }

    @Override
    public boolean delete(ReportDTO reportDTO) {
        try {
            if (reportDTO == null || reportDTO.getId() == null) return false;
            Optional<Report> report = reportRepository.findById(reportDTO.getId());
            if (report != null && report.isPresent()) {
                //delete
                reportRepository.delete(report.get());
                return true;
            }
            return false;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}

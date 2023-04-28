package com.training.controller;

import com.training.consts.ApiPath;
import com.training.dto.CategoryDTO;
import com.training.dto.ReportDTO;
import com.training.repository.ReportRepository;
import com.training.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReportController {
    @Autowired
    ReportRepository reportRepository;

    @Autowired
    ReportService service;

    @PostMapping(value = ApiPath.REPORT_CREATE)
    public ReportDTO newReport(@RequestBody ReportDTO newReport) {
        return service.save(newReport);
    }

    @GetMapping(value = ApiPath.REPORT_GET_ALL)
    public List<ReportDTO> getAllReports() {
        return service.findAll();
    }

    @GetMapping(value = ApiPath.REPORT_BY_ID)
    public ReportDTO getReportById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping(value = ApiPath.REPORT_UPDATE)
    public Integer updateReport(@RequestBody ReportDTO newReport) {
        return service.update(newReport);
    }

    @DeleteMapping(value = ApiPath.REPORT_DELETE)
    public String deleteReport(@RequestBody ReportDTO newReport) {
        boolean isDelete = service.delete(newReport);
        return  isDelete ? "Delete success!!!" : "Delete fail!!!";
    }
}

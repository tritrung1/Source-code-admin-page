package com.training.controller;

import com.training.consts.ApiPath;
import com.training.dto.ReportDTO;
import com.training.repository.ReportRepository;
<<<<<<< Updated upstream
import com.training.service.ReportService;
=======
import com.training.servcie.ReportService;
>>>>>>> Stashed changes
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReportController {
    @Autowired
<<<<<<< Updated upstream
    private ReportRepository reportRepository;

    @Autowired
    ReportService service;

    @PostMapping(value = ApiPath.REPORT_CREATE)
    public ReportDTO newReport(@RequestBody ReportDTO newReport) {
        return service.save(newReport);
    }

    @GetMapping(value = ApiPath.REPORT_GET_ALL)
    public List<ReportDTO> getAllReports() {
        return service.findAll();
=======
    ReportRepository reportRepository;
    @Autowired
    ReportService reportService;
    @PostMapping(value = ApiPath.REPORT_CREATE)
    public ReportDTO newReport(@RequestBody ReportDTO newReport) {
        return reportService.save(newReport);
    }

    @GetMapping(value = ApiPath.REPORT_GET_ALL)
    public List<ReportDTO> getAllReport() {
        return reportService.findAll();
>>>>>>> Stashed changes
    }

    @GetMapping(value = ApiPath.REPORT_BY_ID)
    public ReportDTO getReportById(@PathVariable Long id) {
<<<<<<< Updated upstream
        return service.findById(id);
=======
        return reportService.findById(id);
>>>>>>> Stashed changes
    }

    @PutMapping(value = ApiPath.REPORT_UPDATE)
    public Integer updateReport(@RequestBody ReportDTO newReport) {
<<<<<<< Updated upstream
        return service.update(newReport);
=======
        return reportService.update(newReport);
>>>>>>> Stashed changes
    }

    @DeleteMapping(value = ApiPath.REPORT_DELETE)
    public String deleteReport(@RequestBody ReportDTO newReport) {
<<<<<<< Updated upstream
        boolean isDelete = service.delete(newReport);
        return  isDelete ? "Delete success!!!" : "Delete fail!!!";
=======
        boolean isDelete = reportService.delete(newReport);
        return isDelete ? "Delete success!!!" : "Delete fail!!!";
>>>>>>> Stashed changes
    }
}

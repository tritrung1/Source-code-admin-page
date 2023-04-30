package com.training.service.impl;

import com.fasterxml.uuid.Generators;
import com.training.dto.ReportDTO;
import com.training.entity.Product;
import com.training.entity.Report;
import com.training.mapper.ReportMapper;
import com.training.repository.ProductRepository;
import com.training.repository.ReportRepository;
import com.training.service.ProductService;
import com.training.service.ReportService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    ReportRepository reportRepository;
    @Autowired
    ProductRepository productRepository;

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
        // get unique uuid
        UUID uuid = Generators.timeBasedGenerator().generate();

        // set field or data for generate UUID
        reportDTO.setReportUuid(uuid.toString());

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
    @Override
    public String exportReport(String reportType) throws FileNotFoundException, JRException {
        String path = "E:\\ASSINGMENT\\Mock Project\\sourceTrung\\Source-code-admin-page\\report";
        List<Product> products = productRepository.findAll();
        //load file and compile it
        File file = ResourceUtils.getFile("classpath:product.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(products);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Thanh");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        if (reportType.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\ProductReport.html");
        }
        if (reportType.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\ProductReport.pdf");
        }

        return "report generated in path : " + path;
    }
}

package com.training.controller;

import com.training.consts.ApiPath;
import com.training.dto.ImportDTO;
import com.training.repository.ImportRepository;
import com.training.service.ImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ImportController {
    @Autowired
    private ImportRepository importRepository;

    @Autowired
    ImportService service;

    @PostMapping(value = ApiPath.IMPORT_CREATE)
    public ImportDTO newImport(@RequestBody ImportDTO newImport) {
        return service.save(newImport);
    }

    @GetMapping(value = ApiPath.IMPORT_GET_ALL)
    public List<ImportDTO> getAllImports() {
        return service.findAll();
    }

    @GetMapping(value = ApiPath.IMPORT_BY_ID)
    public ImportDTO getImportById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping(value = ApiPath.IMPORT_UPDATE)
    public Integer updateImport(@RequestBody ImportDTO newImport) {
        return service.update(newImport);
    }

    @DeleteMapping(value = ApiPath.IMPORT_DELETE)
    public String deleteImport(@RequestBody ImportDTO newImport) {
        boolean isDelete = service.delete(newImport);
        return  isDelete ? "Delete success!!!" : "Delete fail!!!";
    }
}

package com.training.service.impl;

import com.training.dto.ImportDTO;
import com.training.entity.Import;
import com.training.mapper.ImportMapper;
import com.training.repository.ImportRepository;
import com.training.service.ImportService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ImportServiceImpl implements ImportService {
    @Autowired
    ImportRepository importRepository;

    @Autowired
    ImportMapper importMapper;

    @Override
    public List<ImportDTO> findAll() {
        List<Import> imports = importRepository.findAll();
        return imports == null || imports.size() == 0 ? new ArrayList<>()
                : imports.stream().map(item -> importMapper.convertEntityToDTO(item))
                .collect(Collectors.toList());
    }

    @Override
    public ImportDTO findById(Long id) {
        Optional<Import> imports = importRepository.findById(id);
        return imports != null && imports.isPresent() ? importMapper.convertEntityToDTO(imports.get())
                : new ImportDTO();
    }

    @Override
    public ImportDTO save(ImportDTO importDTO) {
        if (importDTO == null) return new ImportDTO();
        Import imports = importRepository.save(importMapper.convertDTOToEntity(importDTO));
        return imports == null ? new ImportDTO() : importMapper.convertEntityToDTO(imports);
    }

    @Override
    public int update(ImportDTO importDTO) {
        if (importDTO == null || importDTO.getId() == null) return -1;
        Optional<Import> imports = importRepository.findById(importDTO.getId());
        if (imports != null && imports.isPresent()) {
            //update
            Import importsUpdate = importRepository.save(importMapper.convertDTOToEntity(importDTO));
            return importsUpdate == null ? 0 : 1;
        }
        return -1;
    }

    @Override
    public boolean delete(ImportDTO importDTO) {
        try {
            if (importDTO == null || importDTO.getId() == null) return false;
            Optional<Import> imports = importRepository.findById(importDTO.getId());
            if (imports != null && imports.isPresent()) {
                //delete
                importRepository.delete(imports.get());
                return true;
            }
            return false;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}

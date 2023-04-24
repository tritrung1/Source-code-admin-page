package com.training.mapper;

import com.training.dto.ImportDTO;
import com.training.entity.Import;
import org.springframework.stereotype.Service;

@Service
public class ImportMapper extends AbstractMapper<Import, ImportDTO> {
    public ImportMapper() {
        super(Import.class, ImportDTO.class);
    }
}

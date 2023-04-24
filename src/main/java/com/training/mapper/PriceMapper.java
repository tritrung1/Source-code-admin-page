package com.training.mapper;

import com.training.dto.PriceDTO;
import com.training.entity.Price;
import org.springframework.stereotype.Service;

@Service
public class PriceMapper extends AbstractMapper<Price, PriceDTO> {
    public PriceMapper() {
        super(Price.class, PriceDTO.class);
    }
}

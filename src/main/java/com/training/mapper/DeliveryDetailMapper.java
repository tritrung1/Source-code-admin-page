package com.training.mapper;

import com.training.dto.DeliveryDetailDTO;
import com.training.entity.DeliveryDetail;

import org.springframework.stereotype.Service;

@Service
public class DeliveryDetailMapper extends AbstractMapper<DeliveryDetail, DeliveryDetailDTO> {
    public DeliveryDetailMapper() {
        super(DeliveryDetail.class, DeliveryDetailDTO.class);
    }
}

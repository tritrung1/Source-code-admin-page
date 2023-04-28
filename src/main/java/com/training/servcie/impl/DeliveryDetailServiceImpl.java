package com.training.servcie.impl;

import com.fasterxml.uuid.Generators;
import com.training.dto.DeliveryDetailDTO;
import com.training.entity.DeliveryDetail;
import com.training.mapper.DeliveryDetailMapper;
import com.training.repository.DeliveryDetailRepository;
import com.training.servcie.DeliveryDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DeliveryDetailServiceImpl implements DeliveryDetailService {
    @Autowired
    DeliveryDetailRepository repository;

    @Autowired
    DeliveryDetailMapper mapper;

    @Override
    public List<DeliveryDetailDTO> findAll() {
        List<DeliveryDetail> deliveryDetails = repository.findAll();
        return deliveryDetails == null || deliveryDetails.size() == 0 ? new ArrayList<>()
                : deliveryDetails.stream().map(item -> mapper.convertEntityToDTO(item))
                .collect(Collectors.toList());
    }

    @Override
    public DeliveryDetailDTO findById(Long id) {
        Optional<DeliveryDetail> deliveryDetail = repository.findById(id);
        return deliveryDetail != null && deliveryDetail.isPresent() ? mapper.convertEntityToDTO(deliveryDetail.get())
                : new DeliveryDetailDTO();
    }

    @Override
    public DeliveryDetailDTO save(DeliveryDetailDTO deliveryDetailDTO) {
        if (deliveryDetailDTO == null) return new DeliveryDetailDTO();
        // get unique uuid
        UUID uuid = Generators.timeBasedGenerator().generate();

        // set field or data for generate UUID
        deliveryDetailDTO.setDeliveryDetailUuid(uuid.toString());

        DeliveryDetail deliveryDetail = repository.save(mapper.convertDTOToEntity(deliveryDetailDTO));
        return deliveryDetail == null ? new DeliveryDetailDTO() : mapper.convertEntityToDTO(deliveryDetail);
    }

    @Override
    public int update(DeliveryDetailDTO deliveryDetailDTO) {
        if (deliveryDetailDTO == null || deliveryDetailDTO.getId() == null) return -1;
        Optional<DeliveryDetail> deliveryDetail = repository.findById(deliveryDetailDTO.getId());
        if (deliveryDetail != null && deliveryDetail.isPresent()) {
            //update
            DeliveryDetail deliveryDetailUpdate = repository.save(mapper.convertDTOToEntity(deliveryDetailDTO));
            return deliveryDetailUpdate == null ? 0 : 1;
        }
        return -1;
    }

    @Override
    public boolean delete(DeliveryDetailDTO deliveryDetailDTO) {
        try {
            if (deliveryDetailDTO == null || deliveryDetailDTO.getId() == null) return false;
            Optional<DeliveryDetail> deliveryDetail = repository.findById(deliveryDetailDTO.getId());
            if (deliveryDetail != null && deliveryDetail.isPresent()) {
                //delete
                repository.delete(deliveryDetail.get());
                return true;
            }
            return false;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}

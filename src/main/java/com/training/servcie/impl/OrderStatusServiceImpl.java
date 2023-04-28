package com.training.servcie.impl;

import com.fasterxml.uuid.Generators;
import com.training.dto.OrderStatusDTO;
import com.training.entity.OrderStatus;
import com.training.mapper.OrderStatusMapper;
import com.training.repository.OrderStatusRepository;
import com.training.servcie.OrderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderStatusServiceImpl implements OrderStatusService {
    @Autowired
    OrderStatusRepository repository;

    @Autowired
    OrderStatusMapper mapper;

    @Override
    public List<OrderStatusDTO> findAll() {
        List<OrderStatus> orderStatus = repository.findAll();
        return orderStatus == null || orderStatus.size() == 0 ? new ArrayList<>()
                : orderStatus.stream().map(item -> mapper.convertEntityToDTO(item))
                .collect(Collectors.toList());
    }

    @Override
    public OrderStatusDTO findById(Long id) {
        Optional<OrderStatus> orderStatus = repository.findById(id);
        return orderStatus != null && orderStatus.isPresent() ? mapper.convertEntityToDTO(orderStatus.get())
                : new OrderStatusDTO();
    }

    @Override
    public OrderStatusDTO save(OrderStatusDTO orderStatusDTO) {
        if (orderStatusDTO == null) return new OrderStatusDTO();
        // get unique uuid
        UUID uuid = Generators.timeBasedGenerator().generate();

        // set field or data for generate UUID
        orderStatusDTO.setOrderStatusUuid(uuid.toString());

        OrderStatus orderStatus = repository.save(mapper.convertDTOToEntity(orderStatusDTO));
        return orderStatus == null ? new OrderStatusDTO() : mapper.convertEntityToDTO(orderStatus);
    }

    @Override
    public int update(OrderStatusDTO orderStatusDTO) {
        if (orderStatusDTO == null || orderStatusDTO.getId() == null) return -1;
        Optional<OrderStatus> orderStatus = repository.findById(orderStatusDTO.getId());
        if (orderStatus != null && orderStatus.isPresent()) {
            //update
            OrderStatus orderStatusUpdate = repository.save(mapper.convertDTOToEntity(orderStatusDTO));
            return orderStatusUpdate == null ? 0 : 1;
        }
        return -1;
    }

    @Override
    public boolean delete(OrderStatusDTO orderStatusDTO) {
        try {
            if (orderStatusDTO == null || orderStatusDTO.getId() == null) return false;
            Optional<OrderStatus> orderStatus = repository.findById(orderStatusDTO.getId());
            if (orderStatus != null && orderStatus.isPresent()) {
                //delete
                repository.delete(orderStatus.get());
                return true;
            }
            return false;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}

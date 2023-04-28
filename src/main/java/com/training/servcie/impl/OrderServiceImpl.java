package com.training.servcie.impl;

import com.fasterxml.uuid.Generators;
import com.training.dto.OrderDTO;
import com.training.entity.Order;
import com.training.mapper.OrderMapper;
import com.training.repository.OrderRepository;
import com.training.servcie.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository repository;

    @Autowired
    OrderMapper mapper;

    @Override
    public List<OrderDTO> findAll() {
        List<Order> orders = repository.findAll();
        return orders == null || orders.size() == 0 ? new ArrayList<>()
                : orders.stream().map(item -> mapper.convertEntityToDTO(item))
                .collect(Collectors.toList());
    }

    @Override
    public OrderDTO findById(Long id) {
        Optional<Order> orderList = repository.findById(id);
        return orderList != null && orderList.isPresent() ? mapper.convertEntityToDTO(orderList.get())
                : new OrderDTO();
    }

    @Override
    public OrderDTO save(OrderDTO orderDTO) {
        if (orderDTO == null) return new OrderDTO();
        // get unique uuid
        UUID uuid = Generators.timeBasedGenerator().generate();

        // set field or data for generate UUID
        orderDTO.setOrderUuid(uuid.toString());

        Order order = repository.save(mapper.convertDTOToEntity(orderDTO));
        return order == null ? new OrderDTO() : mapper.convertEntityToDTO(order);
    }

    @Override
    public int update(OrderDTO orderDTO) {
        if (orderDTO == null || orderDTO.getId() == null) return -1;
        Optional<Order> orderList = repository.findById(orderDTO.getId());
        if (orderList != null && orderList.isPresent()) {
            //update
            Order orderUpdate = repository.save(mapper.convertDTOToEntity(orderDTO));
            return orderUpdate == null ? 0 : 1;
        }
        return -1;
    }

    @Override
    public boolean delete(OrderDTO orderDTO) {
        try {
            if (orderDTO == null || orderDTO.getId() == null) return false;
            Optional<Order> orderList = repository.findById(orderDTO.getId());
            if (orderList != null && orderList.isPresent()) {
                //delete
                repository.delete(orderList.get());
                return true;
            }
            return false;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}

package com.training.controller;

import com.training.consts.ApiPath;
import com.training.dto.OrderDTO;
import com.training.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class OrderController {

    @Autowired
    OrderService service;

    @PostMapping(value = ApiPath.ORDER_CREATE)
    public OrderDTO newOrder(@RequestBody OrderDTO newOrder) {
        return service.save(newOrder);
    }

    @GetMapping(value = ApiPath.ORDER_GET_ALL)
    public List<OrderDTO> getAllOrders() {
        return service.findAll();
    }

    @GetMapping(value = ApiPath.ORDER_BY_ID)
    public OrderDTO getOrderById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping(value = ApiPath.ORDER_UPDATE)
    public Integer updateOrder(@RequestBody OrderDTO newOrder) {
        return service.update(newOrder);
    }

    @DeleteMapping(value = ApiPath.ORDER_DELETE)
    public String deleteOrder(@RequestBody OrderDTO newOrder) {
        boolean isDelete = service.delete(newOrder);
        return  isDelete ? "Delete success!!!" : "Delete fail!!!";
    }

}

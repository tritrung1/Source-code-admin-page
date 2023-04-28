package com.training.controller;

import com.training.consts.ApiPath;
import com.training.dto.OrderStatusDTO;
import com.training.service.OrderStatusService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class OrderStatusController {

    @Autowired
    OrderStatusService service;

    @PostMapping(value = ApiPath.ORDER_STATUS_CREATE)
    public OrderStatusDTO newOrderStatus(@RequestBody OrderStatusDTO newOrderStatus) {
        return service.save(newOrderStatus);
    }

    @GetMapping(value = ApiPath.ORDER_STATUS_GET_ALL)
    public List<OrderStatusDTO> getAllOrderStatus() {
        return service.findAll();
    }

    @GetMapping(value = ApiPath.ORDER_STATUS_BY_ID)
    public OrderStatusDTO getOrderStatusById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping(value = ApiPath.ORDER_STATUS_UPDATE)
    public Integer updateOrderStatus(@RequestBody OrderStatusDTO newOrderStatus) {
        return service.update(newOrderStatus);
    }

    @DeleteMapping(value = ApiPath.ORDER_STATUS_DELETE)
    public String deleteOrderStatus(@RequestBody OrderStatusDTO newOrderStatus) {
        boolean isDelete = service.delete(newOrderStatus);
        return  isDelete ? "Delete success!!!" : "Delete fail!!!";
    }

}

package com.training.controller;

import com.training.consts.ApiPath;
import com.training.dto.DeliveryDetailDTO;
import com.training.service.DeliveryDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class DeliveryDetailController {

    @Autowired
    DeliveryDetailService service;

    @PostMapping(value = ApiPath.DELIVERY_DETAIL_CREATE)
    public DeliveryDetailDTO newDeliveryDetail(@RequestBody DeliveryDetailDTO newDeliveryDetail) {
        return service.save(newDeliveryDetail);
    }

    @GetMapping(value = ApiPath.DELIVERY_DETAIL_GET_ALL)
    public List<DeliveryDetailDTO> getAllDeliveryDetails() {
        return service.findAll();
    }

    @GetMapping(value = ApiPath.DELIVERY_DETAIL_BY_ID)
    public DeliveryDetailDTO getDeliveryDetailById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping(value = ApiPath.DELIVERY_DETAIL_UPDATE)
    public Integer updateDeliveryDetail(@RequestBody DeliveryDetailDTO newDeliveryDetail) {
        return service.update(newDeliveryDetail);
    }

    @DeleteMapping(value = ApiPath.DELIVERY_DETAIL_DELETE)
    public String deleteDeliveryDetail(@RequestBody DeliveryDetailDTO newDeliveryDetail) {
        boolean isDelete = service.delete(newDeliveryDetail);
        return  isDelete ? "Delete success!!!" : "Delete fail!!!";
    }

}

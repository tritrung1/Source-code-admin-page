package com.training.controller;

import com.training.consts.ApiPath;
import com.training.dto.PriceDTO;
import com.training.repository.PriceRepository;
import com.training.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PriceController {
    @Autowired
    private PriceRepository priceRepository;

    @Autowired
    PriceService service;

    @PostMapping(value = ApiPath.PRICE_CREATE)
    public PriceDTO newPrice(@RequestBody PriceDTO newPrice) {
        return service.save(newPrice);
    }

    @GetMapping(value = ApiPath.PRICE_GET_ALL)
    public List<PriceDTO> getAllPrices() {
        return service.findAll();
    }

    @GetMapping(value = ApiPath.PRICE_BY_ID)
    public PriceDTO getPriceById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping(value = ApiPath.PRICE_UPDATE)
    public Integer updatePrice(@RequestBody PriceDTO newPrice) {
        return service.update(newPrice);
    }

    @DeleteMapping(value = ApiPath.PRICE_DELETE)
    public String deletePrice(@RequestBody PriceDTO newPrice) {
        boolean isDelete = service.delete(newPrice);
        return  isDelete ? "Delete success!!!" : "Delete fail!!!";
    }
}

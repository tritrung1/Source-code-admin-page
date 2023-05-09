package com.training.controller;

import com.training.consts.ApiPath;
import com.training.dto.ItemDTO;
import com.training.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {
    @Autowired
    ItemService service;

    @PostMapping(value = ApiPath.ITEM_CREATE)
    public ItemDTO newItem(@RequestBody ItemDTO newItem) {
        return service.save(newItem);
    }

    @GetMapping(value = ApiPath.ITEM_GET_ALL)
    public List<ItemDTO> getAllItems() {
        return service.findAll();
    }

    @GetMapping(value = ApiPath.ITEM_BY_ID)
    public ItemDTO getItemById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping(value = ApiPath.ITEM_UPDATE)
    public Integer updateItem(@RequestBody ItemDTO newItem) {
        return service.update(newItem);
    }

    @DeleteMapping(value = ApiPath.ITEM_DELETE)
    public String deleteItem(@RequestBody ItemDTO newItem) {
        boolean isDelete = service.delete(newItem);
        return  isDelete ? "Delete success!!!" : "Delete fail!!!";
    }
}

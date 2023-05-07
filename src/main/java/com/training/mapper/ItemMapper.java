package com.training.mapper;

import com.training.dto.ItemDTO;
import com.training.entity.Item;
import org.springframework.stereotype.Service;

@Service
public class ItemMapper extends AbstractMapper<Item, ItemDTO> {
    public ItemMapper() {
        super(Item.class, ItemDTO.class);
    }
}
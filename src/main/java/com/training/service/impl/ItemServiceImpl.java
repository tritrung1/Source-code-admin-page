package com.training.service.impl;

import com.fasterxml.uuid.Generators;
import com.training.dto.AccountDTO;
import com.training.dto.ItemDTO;
import com.training.entity.Account;
import com.training.entity.Item;
import com.training.mapper.ItemMapper;
import com.training.repository.ItemRepository;
import com.training.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ItemMapper itemMapper;

    @Override
    public List<ItemDTO> findAll() {
        List<Item> items = itemRepository.findAll();
        return items == null || items.size() == 0 ? new ArrayList<>()
                : items.stream().map(item -> itemMapper.convertEntityToDTO(item))
                .collect(Collectors.toList());
    }

    @Override
    public ItemDTO findById(Long id) {
        Optional<Item> item = itemRepository.findById(id);
        return item != null && item.isPresent() ? itemMapper.convertEntityToDTO(item.get())
                : new ItemDTO();
    }

    @Override
    public ItemDTO save(ItemDTO itemDTO) {
        if (itemDTO == null) return new ItemDTO();
        // get unique uuid
        UUID uuid = Generators.timeBasedGenerator().generate();

        // set field or data for generate UUID
        itemDTO.setItemUuid(uuid.toString());

        Item item = itemRepository.save(itemMapper.convertDTOToEntity(itemDTO));
        return item == null ? new ItemDTO() : itemMapper.convertEntityToDTO(item);
    }

    @Override
    public int update(ItemDTO itemDTO) {
        if (itemDTO == null || itemDTO.getId() == null) return -1;
        Optional<Item> item = itemRepository.findById(itemDTO.getId());
        if (item != null && item.isPresent()) {
            //update
            Item itemUpdate = itemRepository.save(itemMapper.convertDTOToEntity(itemDTO));
            return itemUpdate == null ? 0 : 1;
        }
        return -1;
    }

    @Override
    public boolean delete(ItemDTO itemDTO) {
        try {
            if (itemDTO == null || itemDTO.getId() == null) return false;
            Optional<Item> item = itemRepository.findById(itemDTO.getId());
            if (item != null && item.isPresent()) {
                //delete
                itemRepository.delete(item.get());
                return true;
            }
            return false;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}

package com.training.service.impl;

import com.training.dto.PriceDTO;
import com.training.entity.Price;
import com.training.mapper.PriceMapper;
import com.training.repository.PriceRepository;
import com.training.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PriceServiceImpl implements PriceService {
    @Autowired
    PriceRepository priceRepository;

    @Autowired
    PriceMapper priceMapper;

    @Override
    public List<PriceDTO> findAll() {
        List<Price> prices = priceRepository.findAll();
        return prices == null || prices.size() == 0 ? new ArrayList<>()
                : prices.stream().map(item -> priceMapper.convertEntityToDTO(item))
                .collect(Collectors.toList());
    }

    @Override
    public PriceDTO findById(Long id) {
        Optional<Price> price = priceRepository.findById(id);
        return price != null && price.isPresent() ? priceMapper.convertEntityToDTO(price.get())
                : new PriceDTO();
    }

    @Override
    public PriceDTO save(PriceDTO priceDTO) {
        if (priceDTO == null) return new PriceDTO();
        Price price = priceRepository.save(priceMapper.convertDTOToEntity(priceDTO));
        return price == null ? new PriceDTO() : priceMapper.convertEntityToDTO(price);
    }

    @Override
    public int update(PriceDTO priceDTO) {
        if (priceDTO == null || priceDTO.getId() == null) return -1;
        Optional<Price> price = priceRepository.findById(priceDTO.getId());
        if (price != null && price.isPresent()) {
            //update
            Price priceUpdate = priceRepository.save(priceMapper.convertDTOToEntity(priceDTO));
            return priceUpdate == null ? 0 : 1;
        }
        return -1;
    }

    @Override
    public boolean delete(PriceDTO priceDTO) {
        try {
            if (priceDTO == null || priceDTO.getId() == null) return false;
            Optional<Price> price = priceRepository.findById(priceDTO.getId());
            if (price != null && price.isPresent()) {
                //delete
                priceRepository.delete(price.get());
                return true;
            }
            return false;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}

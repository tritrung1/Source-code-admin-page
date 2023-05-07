package com.training.utils;

import com.training.dto.ItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class RestItem {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/cartItems")
    public void getItem() {
        String resourceUrl
                = "http://localhost:8080/api/v1/cartItems";
        ResponseEntity<List<ItemDTO>> itemResponse = restTemplate.exchange(resourceUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<ItemDTO>>() {});
        List<ItemDTO> items = itemResponse.getBody();
        items.forEach(x -> System.out.println(x.toString()));

    }

}

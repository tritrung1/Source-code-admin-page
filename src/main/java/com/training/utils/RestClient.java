package com.training.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestClient<T> {
    @Value("${spring.rest-template.read-timeout}")
    String urlRead;

    @Value("${spring.rest-template.connect-timeout}")
    String urlConnect;

    private RestTemplate restTemplate;

    public RestClient() {
        this.restTemplate = new RestTemplate();
    }

    public ResponseEntity<T> get(Class<T> responseType) {
        ResponseEntity<T> response = restTemplate.exchange(urlRead, HttpMethod.GET, null, responseType);
        return response;
    }

    public ResponseEntity<T> post(T request, Class<T> responseType) {
        HttpEntity<T> httpEntity = new HttpEntity<>(request);
        ResponseEntity<T> response = restTemplate.exchange(urlRead, HttpMethod.POST, httpEntity, responseType);
        return response;
    }

    public ResponseEntity<T> put(T request, Class<T> responseType) {
        HttpEntity<T> httpEntity = new HttpEntity<>(request);
        ResponseEntity<T> response = restTemplate.exchange(urlRead, HttpMethod.PUT, httpEntity, responseType);
        return response;
    }

    public ResponseEntity<T> delete(Class<T> responseType) {
        ResponseEntity<T> response = restTemplate.exchange(urlRead, HttpMethod.DELETE, null, responseType);
        return response;
    }
}

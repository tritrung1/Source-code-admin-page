package com.training.service;

import com.training.dto.NewsDTO;
import com.training.entity.News;

import java.util.List;

public interface NewsService extends BaseService<NewsDTO> {
    List<NewsDTO> findBySoldDatePending();
    public List<NewsDTO> findByAccount(String accountName);
}

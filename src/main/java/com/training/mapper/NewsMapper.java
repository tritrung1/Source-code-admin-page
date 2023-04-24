package com.training.mapper;

import com.training.dto.NewsDTO;
import com.training.entity.News;
import org.springframework.stereotype.Service;

@Service
public class NewsMapper  extends AbstractMapper<News, NewsDTO>{
    public NewsMapper() {
        super(News.class, NewsDTO.class);
    }
}

package com.training.service.impl;

import com.training.dto.NewsDTO;
import com.training.entity.News;
import com.training.mapper.NewsMapper;
import com.training.repository.NewsRepository;
import com.training.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    NewsRepository repository;

    @Autowired
    NewsMapper mapper;
    @Override
    public List<NewsDTO> findAll() {
        List<News> news = repository.findAll();
        return news == null || news.size() == 0 ? new ArrayList<>()
                : news.stream().map(item -> mapper.convertEntityToDTO(item))
                .collect(Collectors.toList());
    }

    @Override
    public NewsDTO findById(Long id) {
        Optional<News> news = repository.findById(id);
        return news != null && news.isPresent() ? mapper.convertEntityToDTO(news.get())
                : new NewsDTO();
    }

    @Override
    public NewsDTO save(NewsDTO newsDTO) {
        if (newsDTO == null) return new NewsDTO();
        News news = repository.save(mapper.convertDTOToEntity(newsDTO));
        return news == null ? new NewsDTO() : mapper.convertEntityToDTO(news);
    }

    @Override
    public int update(NewsDTO newsDTO) {
        if (newsDTO == null || newsDTO.getId() == null) return -1;
        Optional<News> news = repository.findById(newsDTO.getId());
        if (news != null && news.isPresent()) {
            //update
            News newsUpdate = repository.save(mapper.convertDTOToEntity(newsDTO));
            return newsUpdate == null ? 0 : 1;
        }
        return -1;
    }

    @Override
    public boolean delete(NewsDTO newsDTO) {
        try {
            if (newsDTO == null || newsDTO.getId() == null) return false;
            Optional<News> news = repository.findById(newsDTO.getId());
            if (news != null && news.isPresent()) {
                //delete
                repository.delete(news.get());
                return true;
            }
            return false;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}

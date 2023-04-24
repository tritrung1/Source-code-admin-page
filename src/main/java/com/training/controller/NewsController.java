package com.training.controller;

import com.training.consts.ApiPath;
import com.training.dto.NewsDTO;
import com.training.repository.NewsRepository;
import com.training.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NewsController {
    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    NewsService service;

    @GetMapping(value = ApiPath.PING)
    public String ping() {
        return "Ping!!!!!!!!";
    }

    @PostMapping(value = ApiPath.NEWS_CREATE)
    public NewsDTO newNews(@RequestBody NewsDTO newNews) {
        return service.save(newNews);
    }

    @GetMapping(value = ApiPath.NEWS_GET_ALL)
    public List<NewsDTO> getAllNews() {
        return service.findAll();
    }

    @GetMapping(value = ApiPath.NEWS_BY_ID)
    public NewsDTO getNewsById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping(value = ApiPath.NEWS_UPDATE)
    public Integer updateNews(@RequestBody NewsDTO newNews) {
        return service.update(newNews);
    }

    @DeleteMapping(value = ApiPath.NEWS_DELETE)
    public String deleteNews(@RequestBody NewsDTO newNews) {
        boolean isDelete = service.delete(newNews);
        return  isDelete ? "Delete success!!!" : "Delete fail!!!";
    }
}

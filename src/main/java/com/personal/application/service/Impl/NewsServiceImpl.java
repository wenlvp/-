package com.personal.application.service.Impl;

import com.personal.application.mapper.NewsMapper;
import com.personal.application.pojo.News;
import com.personal.application.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsMapper newsMapper;


    @Override
    public List<News> findNewsList(Integer newsType) {
        return newsMapper.findNewsList(newsType);
    }

    @Override
    public List<News> findNewsListById(Integer newsId) {
        return newsMapper.findNewListById(newsId);
    }
}

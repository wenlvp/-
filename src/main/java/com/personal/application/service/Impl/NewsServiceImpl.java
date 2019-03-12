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
    public List<News> findNewsList(Integer newsType,String title,Integer startRow,Integer pageSize) {
        return newsMapper.findNewsList(newsType,title,startRow,pageSize);
    }

    @Override
    public List<News> findNewsListById(Integer newsId) {
        return newsMapper.findNewListById(newsId);
    }

    @Override
    public List<News> findAuditNewsList(Integer startRow, Integer pageSize) {
         return newsMapper.findAuditNewsList(startRow,pageSize);
    }


}

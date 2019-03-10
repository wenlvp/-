package com.personal.application.service;


import com.personal.application.pojo.News;

import java.util.List;

public interface NewsService {
     List<News> findNewsList(Integer newsType);

     List<News> findNewsListById(Integer newsId);
}

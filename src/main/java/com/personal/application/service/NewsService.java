package com.personal.application.service;


import com.personal.application.pojo.News;

import java.util.List;

public interface NewsService {
     List<News> findNewsList(Integer newsType,Integer selConditions,String selContent,Integer startRow,Integer pageSize);

     List<News> findNewsListById(Integer newsId);

     List<News> findAuditNewsList(Integer startRow,Integer pageSize );

     List<News> findAllNewsList(Integer newsType,String title,Integer startRow,Integer pageSize);

     Integer addReadNum(Integer newsId);

     Integer changeAgree(Integer newsId,String userId);

     Integer getIsAgree(Integer newsId, String userId);
}

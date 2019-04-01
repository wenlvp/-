package com.personal.application.service.Impl;

import com.personal.application.common.Constant;
import com.personal.application.mapper.NewsMapper;
import com.personal.application.mapper.NoticeMapper;
import com.personal.application.pojo.News;
import com.personal.application.pojo.Notice;
import com.personal.application.repository.NewsRepository;
import com.personal.application.repository.NoticeRepository;
import com.personal.application.service.NewsService;
import com.personal.application.util.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsMapper newsMapper;
    @Autowired
    private NoticeMapper noticeMapper;
    @Autowired
    private NewsRepository newsRepository;

    @Override
    public List<News> findNewsList(Integer newsType, Integer selConditions, String selContent, Integer startRow, Integer pageSize) {
        return newsMapper.findNewsList(newsType,selConditions,selContent,startRow,pageSize);
    }

    @Override
    public List<News> findNewsListById(Integer newsId) {
        return newsMapper.findNewListById(newsId);
    }

    @Override
    public List<News> findAuditNewsList(Integer startRow, Integer pageSize) {
         return newsMapper.findAuditNewsList(startRow,pageSize);
    }

    @Override
    public List<News> findAllNewsList(Integer newsType, String title, Integer startRow, Integer pageSize) {
        return newsMapper.findAllNewsList(newsType,title,startRow,pageSize);
    }

    @Override
    public Integer addReadNum(Integer newsId) {
        return newsMapper.addReadNum(newsId);
    }

    @Override
    public Integer changeAgree(Integer newsId, String userId) {
        Integer successFlg = 0;
        Integer agreeFlg = newsMapper.getAgreeById(newsId, userId);
        if (agreeFlg == 2){
            successFlg +=  newsMapper.addAgree(newsId,userId);
            newsMapper.changeAgreeNum(newsId,0);
            if (successFlg>0){
                noticeMapper.addNotice(new Notice(Constant.NEWS_AGREE_MSG,newsId,userId));
            }
        }else if(agreeFlg == 0){
            successFlg += newsMapper.updateAgreeFlg(newsId,userId,1);
            newsMapper.changeAgreeNum(newsId,1);
        }else if(agreeFlg == 1){
            successFlg += newsMapper.updateAgreeFlg(newsId,userId,0);
            if (successFlg>0){
                noticeMapper.addNotice(new Notice(Constant.NEWS_AGREE_MSG,newsId,userId));
            }
            newsMapper.changeAgreeNum(newsId,0);
        }

        return successFlg;
    }

    @Override
    public Integer getIsAgree(Integer newsId, String userId) {
        return  newsMapper.getAgreeById(newsId, userId);
    }

    @Override
    public void addNews(News news) {
        newsMapper.addNews(news);
    }


}

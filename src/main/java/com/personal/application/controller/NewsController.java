package com.personal.application.controller;

import com.personal.application.VO.ResultVO;
import com.personal.application.pojo.News;
import com.personal.application.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private NewsService newsService;
    @PostMapping("find")
    public ResultVO findNewsList(@RequestParam(value = "newsType",required = false) Integer newsType,
                                 @RequestParam(value = "title",required = false) String title,
                                 @RequestParam(value = "pageSize",required = false) Integer pageSize,
                                 @RequestParam(value = "pageIndex",required = false) Integer pageIndex){
        ResultVO resultVO = new ResultVO();
        int startRow = (pageIndex-1) * pageSize ;
        List<News> newsList = newsService.findNewsList(newsType,title,startRow,pageSize);
        resultVO.setData(newsList);
        resultVO.setSuccess(true);
        return  resultVO;
    }

    @PostMapping("findBy")
    public ResultVO findNewsListById(@RequestParam(value = "newsId") Integer newsId){
        ResultVO resultVO = new ResultVO();
        List<News> newsList = newsService.findNewsListById(newsId);
        resultVO.setData(newsList);
        resultVO.setSuccess(true);
        return  resultVO;
    }

    @PostMapping("findAudit")
    public ResultVO findAuditNewsList(@RequestParam(value = "pageSize",required = false) Integer pageSize,
                                      @RequestParam(value = "pageIndex",required = false) Integer pageIndex){
        ResultVO resultVO = new ResultVO();
        int startRow = (pageIndex-1) * pageSize ;
        List<News> newsList = newsService.findAuditNewsList(startRow,pageSize);
        resultVO.setData(newsList);
        resultVO.setSuccess(true);
        return  resultVO;
    }
}

package com.personal.application.controller;

import com.personal.application.VO.ResultVO;
import com.personal.application.common.Constant;
import com.personal.application.pojo.News;
import com.personal.application.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @PostMapping("find")
    public ResultVO findNewsList(@RequestParam(value = "newsType",required = false) Integer newsType,
                                 @RequestParam(value = "selConditions",required = false) Integer selConditions,
                                 @RequestParam(value = "selContent",required = false) String selContent,
                                 @RequestParam(value = "pageSize",required = false) Integer pageSize,
                                 @RequestParam(value = "pageIndex",required = false) Integer pageIndex){
        ResultVO resultVO = new ResultVO();
        int startRow = (pageIndex-1) * pageSize ;
        List<News> newsList = newsService.findNewsList(newsType,selConditions, selContent,startRow,pageSize);
        resultVO.beSuccess(newsList);
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
        resultVO.beSuccess(newsList);
        return  resultVO;
    }
    @PostMapping("findAll")
    public ResultVO findAllNewsList(@RequestParam(value = "newsType",required = false) Integer newsType,
                                 @RequestParam(value = "title",required = false) String title,
                                 @RequestParam(value = "pageSize",required = false) Integer pageSize,
                                 @RequestParam(value = "pageIndex",required = false) Integer pageIndex){
        ResultVO resultVO = new ResultVO();
        int startRow = (pageIndex-1) * pageSize ;
        List<News> newsList = newsService.findAllNewsList(newsType,title,startRow,pageSize);
        resultVO.beSuccess(newsList);
        return  resultVO;
    }

    @PostMapping("addNews")
    public ResultVO addNews(@RequestParam(value = "title") String title,
                            @RequestParam(value = "newsType") Integer newsType,
                            @RequestParam(value = "content") String content,
                            HttpSession session){
        ResultVO resultVO = new ResultVO();
        newsService.addNews(new News(title,newsType,session.getAttribute(Constant.LOGIN_ID).toString() ,content));
        resultVO.setSuccess(true);
        return  resultVO;
    }
    @PostMapping("addReadNum")
    public ResultVO addReadNum(@RequestParam(value = "newsId") Integer newsId){
        ResultVO resultVO = new ResultVO();
        newsService.addReadNum(newsId);
        resultVO.setSuccess(true);
        return  resultVO;
    }
    @PostMapping("changeAgreeNum")
    public ResultVO changeAgreeNum(@RequestParam(value = "newsId") Integer newsId,
                                   HttpServletRequest request){
        ResultVO resultVO = new ResultVO();
        HttpSession session = request.getSession();
        newsService.changeAgree(newsId,session.getAttribute(Constant.LOGIN_ID).toString());
        resultVO.setSuccess(true);
        return  resultVO;
    }
    @PostMapping("getIsRead")
    public ResultVO getIsRead(@RequestParam(value = "newsId") Integer newsId,
                              HttpServletRequest request){
        ResultVO resultVO = new ResultVO();
        HttpSession session = request.getSession();
       Integer agreeFlg= newsService.getIsAgree(newsId,session.getAttribute(Constant.LOGIN_ID).toString());
       if (agreeFlg == 0 ){
           resultVO.setSuccess(true);
       }else{
           resultVO.setSuccess(false);
       }

        return  resultVO;
    }

}

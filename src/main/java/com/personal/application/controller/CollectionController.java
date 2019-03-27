package com.personal.application.controller;

import com.personal.application.VO.ResultVO;
import com.personal.application.common.Constant;
import com.personal.application.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/collection")
public class CollectionController {
    @Autowired
    private CollectionService collectionService;


    @PostMapping("changeCollection")
    public ResultVO changeAgreeNum(@RequestParam(value = "newsId") Integer newsId,
                                   HttpServletRequest request){
        ResultVO resultVO = new ResultVO();
        HttpSession session = request.getSession();
        collectionService.changeCollection(newsId,session.getAttribute(Constant.LOGIN_ID).toString());
        resultVO.setSuccess(true);
        return  resultVO;
    }
    @PostMapping("getIsCollect")
    public ResultVO getIsRead(@RequestParam(value = "newsId") Integer newsId,
                              HttpServletRequest request){
        ResultVO resultVO = new ResultVO();
        HttpSession session = request.getSession();
        Integer agreeFlg = collectionService.getIsCollection(newsId,session.getAttribute(Constant.LOGIN_ID).toString());
        if (agreeFlg == 0 ){
            resultVO.setSuccess(true);
        }else{
            resultVO.setSuccess(false);
        }

        return  resultVO;
    }

}

package com.personal.application.controller;

import com.personal.application.VO.ResultVO;
import com.personal.application.service.NoticeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    ResultVO resultVO = new ResultVO();

    @PostMapping("updateFlag")
    public ResultVO updateFlag(@Param("id") Integer id){
        noticeService.updateReadFlag(id);
        resultVO.beSuccess();
        return resultVO;
    }

}

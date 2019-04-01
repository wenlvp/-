package com.personal.application.controller;

import com.personal.application.VO.ResultVO;
import com.personal.application.common.Constant;
import com.personal.application.pojo.Comment;
import com.personal.application.service.CommentService;
import com.personal.application.util.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;
    ResultVO resultVo = new ResultVO();
    @PostMapping("add")
    public ResultVO addComments(@RequestParam(value = "newsId") Integer newsId,
                                @RequestParam(value = "comments") String comments,
                                HttpSession session){
        commentService.addComment(new Comment(newsId,session.getAttribute(Constant.LOGIN_ID).toString(),comments));
        resultVo.beSuccess();
        return resultVo;
    }
    @PostMapping("findBy")
    public ResultVO findComments(@RequestParam(value = "newsId") Integer newsId){
        resultVo.beSuccess(commentService.SelectCommentByNewsId(newsId));
        return resultVo;
    }
}

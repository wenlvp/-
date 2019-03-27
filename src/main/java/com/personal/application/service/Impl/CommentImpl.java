package com.personal.application.service.Impl;

import com.personal.application.mapper.CommentMapper;
import com.personal.application.pojo.Comment;
import com.personal.application.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Override
    public List<Comment> SelectCommentByNewsId(Integer newsId) {
        return commentMapper.SelectCommentByNewsId(newsId);
    }

    @Override
    public Integer addComment(Comment comment) {
        return commentMapper.addComment(comment);
    }
}

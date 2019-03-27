package com.personal.application.service;

import com.personal.application.pojo.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> SelectCommentByNewsId(Integer newsId);

    Integer addComment(Comment comment);
}

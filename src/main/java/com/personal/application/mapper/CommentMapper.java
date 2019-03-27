package com.personal.application.mapper;

import com.personal.application.pojo.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CommentMapper {
    @Insert("<script>" +
            "INSERT INTO COMMENT ( user_id, news_id, COMMENTs,create_time )\n" +
            "VALUES\n" +
            "\t( #{userId}, #{newsId}, #{comments},#{createTime})" +
            "</script>")
    Integer addComment(Comment comment);

    @Select("<script>" +
            "SELECT\n" +
            "\tnews_id,\n" +
            "\tuser_id,\n" +
            "\tcomments,\n" +
            "\tcreate_time \n" +
            "FROM\n" +
            "COMMENT \n" +
            "WHERE\n" +
            "\tnews_id = #{newsId}" +
            "</script>")
    List<Comment> SelectCommentByNewsId(Integer newsId);
}

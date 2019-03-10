package com.personal.application.mapper;

import com.personal.application.pojo.News;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface NewsMapper {
    @Select("<script>" +
            "SELECT\n" +
            "\tn.news_id,\n" +
            "\tu.user_name AS 'userId',\n" +
            "\tn.title,\n" +
            "\tn.pub_time,\n" +
            "\tn.content,\n" +
            "\tn.read_num,\n" +
            "\tn.comment_num,\n" +
            "\tn.news_picture,\n" +
            "\td.dict_name AS 'newsTypeName' \n" +
            "FROM\n" +
            "\tnews n\n" +
            "\tLEFT JOIN user_info u ON n.user_id = u.user_id\n" +
            "\tLEFT JOIN dict d ON d.dict_value = n.news_type \n" +
            "\tAND d.dict_type = 'news'" +
            " where n.is_audit = 0" +
            "<if test ='newsType !=null '>" +
            " and n.news_type = #{newsType}" +
            "</if>" +
            "</script>")
    List<News> findNewsList(@Param("newsType") Integer newsType);

    @Select("<script>" +
            "SELECT\n" +
            "\tn.news_id,\n" +
            "\tu.user_name AS 'userId',\n" +
            "\tn.title,\n" +
            "\tn.pub_time,\n" +
            "\tn.content,\n" +
            "\tn.read_num,\n" +
            "\tn.comment_num,\n" +
            "\tn.news_picture,\n" +
            "\td.dict_name AS 'newsTypeName' \n" +
            "FROM\n" +
            "\tnews n\n" +
            "\tLEFT JOIN user_info u ON n.user_id = u.user_id\n" +
            "\tLEFT JOIN dict d ON d.dict_value = n.news_type \n" +
            "\tAND d.dict_type = 'news' \n" +
            "WHERE\n" +
            "\tnews_id = #{newsId}" +
            "</script>")
    List<News> findNewListById(@Param("newsId") Integer newsId);
}

package com.personal.application.mapper;

import com.personal.application.pojo.Notice;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface NoticeMapper {
    @Insert("<script>" +
            "INSERT INTO notice ( notifier_id, message, news_id, create_user_id, is_read ) SELECT\n" +
            "user_id,\n" +
            " #{message},\n" +
            "#{newsId},\n" +
            "#{createUserId},\n" +
            "1 \n" +
            "FROM\n" +
            "\tnews \n" +
            "WHERE\n" +
            "\tnews_id = #{newsId}" +
            "</script>")
    Integer addNotice(Notice notice);

    @Update("<script>" +
            "update notice\n" +
            "set \n" +
            "is_read = 0\n" +
            "where id = 1" +
            "</script>")
    Integer updateReadFlg(@Param("id") Integer id);
}

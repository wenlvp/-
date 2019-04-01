package com.personal.application.mapper;

import com.personal.application.pojo.Notice;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeMapper {
    @Insert("<script>" +
            "INSERT INTO notice ( notifier_id, message, news_id, create_user_id, is_read ,create_time) SELECT\n" +
            "user_id,\n" +
            " #{message},\n" +
            "#{newsId},\n" +
            "#{createUserId},\n" +
            "0 ,\n" +
            "now()\n" +
            "FROM\n" +
            "\tnews \n" +
            "WHERE\n" +
            "\tnews_id = #{newsId}" +
            "</script>")
    Integer addNotice(Notice notice);

    @Update("<script>" +
            "update notice\n" +
            "set \n" +
            "is_read = 1\n" +
            "where id = #{id}" +
            "</script>")
    Integer updateReadFlg(@Param("id") Integer id);

    @Select("<script>" +
            "SELECT\n" +
            "\tt.* \n" +
            "FROM\n" +
            "\t(\n" +
            "SELECT\n" +
            "\tnotice_temp.id,\n" +
            "\tnotice_temp.message,\n" +
            "\tnews_temp.title,\n" +
            "\tuser_temp.user_name,\n" +
            "\tnotice_temp.notifier_id,\n" +
            "\tnotice_temp.news_id,\n" +
            "\tnotice_temp.is_read as 'readFlg',\n" +
            "\tnotice_temp.create_time \n" +
            "FROM\n" +
            "\tnotice notice_temp\n" +
            "\tLEFT JOIN user_info user_temp ON notice_temp.create_user_id = user_temp.user_id\n" +
            "\tLEFT JOIN news news_temp ON notice_temp.news_id = news_temp.news_id \n" +
            " where 1=1" +
            " <if test=' flag ==null'>" +
            "\tand notice_temp.is_read = 0 " +
            "</if>" +

            "\t AND notice_temp.notifier_id = #{userId}" +
            "\tLIMIT #{startRow},#{pageSize}\n" +
            "\t) t UNION ALL\n" +
            "SELECT\n" +
            "\tcount( notice_temp.id ),\n" +
            "\tnotice_temp.id,\n" +
            "\tnews_temp.title,\n" +
            "\tuser_temp.user_name,\n" +
            "\tnotice_temp.notifier_id,\n" +
            "\tnotice_temp.news_id,\n" +
            "\tnotice_temp.is_read as 'readFlg',\n" +
            "\tnotice_temp.create_time \n" +
            "FROM\n" +
            "\tnotice notice_temp\n" +
            "\tLEFT JOIN user_info user_temp ON notice_temp.create_user_id = user_temp.user_id\n" +
            "\tLEFT JOIN news news_temp ON notice_temp.news_id = news_temp.news_id \n" +
            " where 1=1" +
            " <if test=' flag ==null'>" +
            "\tand notice_temp.is_read = 0 \n" +
            "</if>" +
            "\tAND notice_temp.notifier_id = #{userId}" +
            "</script>"  )
    List<Notice> findNoticeByUserId(@Param("userId") String userId,
                                    @Param("startRow") Integer startRow,
                                    @Param("pageSize") Integer pageSize,
                                    @Param("flag") String flag);
}

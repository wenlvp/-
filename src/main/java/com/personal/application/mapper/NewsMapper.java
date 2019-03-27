package com.personal.application.mapper;

import com.personal.application.pojo.News;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface NewsMapper {
    @Select("<script>" +
            " select t.* from " +
            "(SELECT\n" +
            "\tn.news_id,\n" +
            "\tu.user_name AS 'userId',\n" +
            "\tn.title,\n" +
            "\tn.pub_time,\n" +
            "\tn.content,\n" +
            "\tn.read_num,\n" +
            "\tn.comment_num,\n" +
            "\tn.agree_num,\n" +
            "\tn.news_picture,\n" +
            "\td.dict_name AS 'newsTypeName' \n" +
            "FROM\n" +
            "\tnews n\n" +
            "\tLEFT JOIN user_info u ON n.user_id = u.user_id\n" +
            "\tLEFT JOIN dict d ON d.dict_value = n.news_type \n" +
            "\tAND d.dict_type = 'news'" +
            " where n.is_del = 0" +
            " and n.is_audit = 0" +
            "<if test ='newsType !=null '>" +
            " and n.news_type = #{newsType}" +
            "</if>" +
            "<if test ='selConditions == 1'  >" +
            " \tand instr(n.title,#{selContent})" +
            "</if>" +
            "<if test ='selConditions == 2' >" +
            " \tand instr(u.user_name,#{selContent})" +
            "</if>" +
            "<if test ='selConditions == 3 '>" +
            " \tand instr(n.content,#{selContent})" +
            "</if>" +
            " order by n.pub_time" +
            " limit #{startRow},#{pageSize})t " +
            " union all" +
            " SELECT\n" +
            "\t count(n.news_id),\n" +
            "\tu.user_name AS 'userId',\n" +
            "\tn.title,\n" +
            "\tn.pub_time,\n" +
            "\tn.content,\n" +
            "\tn.read_num,\n" +
            "\tn.comment_num,\n" +
            "\tn.agree_num,\n" +
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
            "<if test ='selConditions == 1'  >" +
            " \tand instr(n.title,#{selContent})" +
            "</if>" +
            "<if test ='selConditions == 2' >" +
            " \tand instr(u.user_name,#{selContent})" +
            "</if>" +
            "<if test =' selConditions == 3 '>" +
            " \tand instr(n.content,#{selContent})" +
            "</if>" +
            "</script>")
    List<News> findNewsList(@Param("newsType") Integer newsType,
                            @Param("selConditions") Integer selConditions,
                            @Param("selContent") String selContent,
                            @Param("startRow") Integer startRow,
                            @Param("pageSize") Integer pageSize);

    @Select("<script>" +
            "SELECT\n" +
            "\tn.news_id,\n" +
            "\tu.user_name AS 'userId',\n" +
            "\tn.title,\n" +
            "\tn.pub_time,\n" +
            "\tn.content,\n" +
            "\tn.read_num,\n" +
            "\tn.comment_num,\n" +
            "\tn.agree_num,\n" +
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

    @Select("<script>" +
            " select t.* from (" +
            "SELECT\n" +
            "\tn.news_id,\n" +
            "\tu.user_name AS 'userId',\n" +
            "\tn.title,\n" +
            "\t n.pub_time,\n" +
            "\tn.content,\n" +
            "\tn.read_num,\n" +
            "\tn.comment_num,\n" +
            "\tn.agree_num,\n" +
            "\tn.news_picture,\n" +
            "\td.dict_name AS 'newsTypeName' \n" +
            "FROM\n" +
            "\tnews n\n" +
            "\tLEFT JOIN user_info u ON n.user_id = u.user_id\n" +
            "\tLEFT JOIN dict d ON d.dict_value = n.news_type \n" +
            "\tAND d.dict_type = 'news'" +

            " where n.is_audit = 1 " +
            " order by n.pub_time desc " +
            " limit #{startRow},#{pageSize}\n ) t" +
            "  \t\t\t\t\t union all\n" +
            "\t\t\t\t\t SELECT\n" +
            "     count(news_id),\n" +
            "      news_id,\n" +
            "     title,\n" +
            "     pub_time,\n" +
            "     content,\n" +
            "     read_num,\n" +
            "     comment_num,\n" +
            "\tagree_num,\n" +
            "     news_picture,\n" +
            "\t\t user_id\n" +
            "            FROM\n" +
            "    news \n" +
            "\t\t where is_audit = 1" +
            "</script>")
    List<News> findAuditNewsList(@Param("startRow") Integer startRow,
                                 @Param("pageSize") Integer pageSize);

    @Select("<script>" +
            " select t.* from " +
            "(SELECT\n" +
            "\tn.news_id,\n" +
            "\tu.user_name AS 'userId',\n" +
            "\tn.title,\n" +
            "\tn.pub_time,\n" +
            "\tn.content,\n" +
            "\tn.read_num,\n" +
            "\tn.comment_num,\n" +
            "\tn.agree_num,\n" +
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
            "<if test ='title !=null '>" +
            " \tand instr(n.title,#{title})" +
            "</if>" +
            " order by n.pub_time" +
            " limit #{startRow},#{pageSize})t " +
            " union all" +
            " SELECT\n" +
            "\t count(n.news_id),\n" +
            "\tu.user_name AS 'userId',\n" +
            "\tn.title,\n" +
            "\tn.pub_time,\n" +
            "\tn.content,\n" +
            "\tn.read_num,\n" +
            "\tn.comment_num,\n" +
            "\tn.agree_num,\n" +
            "\tn.news_picture,\n" +
            "\td.dict_name AS 'newsTypeName' \n" +
            "FROM\n" +
            "\tnews n\n" +
            "\tLEFT JOIN user_info u ON n.user_id = u.user_id\n" +
            "\tLEFT JOIN dict d ON d.dict_value = n.news_type \n" +
            "\tAND d.dict_type = 'news'" +
            "<if test ='newsType !=null '>" +
            " and n.news_type = #{newsType}" +
            "</if>" +
            "<if test ='title !=null '>" +
            " \tand instr(n.title,#{title})" +
            "</if>" +
            "</script>")
    List<News> findAllNewsList(@Param("newsType") Integer newsType,
                               @Param("title") String title,
                               @Param("startRow") Integer startRow,
                               @Param("pageSize") Integer pageSize);

    @Update("<script>" +
            "UPDATE news \n" +
            "SET read_num = read_num + 1 \n" +
            "WHERE\n" +
            "\tnews_id = #{newsId}" +
            "</script>")
   Integer addReadNum(@Param("newsId") Integer newsId);

    @Update("<script>" +
            "UPDATE news \n" +
            "SET " +
            "<if test ='flag == 0 '>" +
            " agree_num = agree_num + 1" +
            "</if>" +
            "<if test ='flag == 1 '>" +
            " agree_num = agree_num - 1" +
            "</if>" +
            "WHERE\n" +
            "\tnews_id = #{newsId}" +
            "</script>")
    Integer changeAgreeNum(@Param("newsId") Integer newsId,
                           @Param("flag") Integer flag);

    @Insert("<script>" +
            "INSERT INTO agree ( user_id, news_id, is_agree )\n" +
            "VALUES\n" +
            "\t( #{userId}, #{newsId}, 0 )" +
            "</script>")
    Integer addAgree(@Param("newsId") Integer newsId,
                     @Param("userId") String userId);


    @Select("<script>" +
            "select \n" +
            "case count(is_agree) \n" +
            "when is_agree=0 then 0\n" +
            "when is_agree=1 then 1\n" +
            "else  2\n" +
            "end as agree\n" +
            "        from agree \n" +
            "        where user_id = #{userId}\n" +
            "        and news_id =#{newsId}" +
            "</script>")
    Integer getAgreeById(@Param("newsId") Integer newsId,
                         @Param("userId") String userId);

    @Insert("<script>" +
            "UPDATE agree \n" +
            "SET is_agree = #{agreeFlg} \n" +
            "WHERE\n" +
            "\tnews_id = #{newsId} and" +
            "\tuser_id = #{userId}" +
            "</script>")
    Integer updateAgreeFlg(@Param("newsId") Integer newsId,
                           @Param("userId") String userId,
                           @Param("agreeFlg") Integer agreeFlg);
}

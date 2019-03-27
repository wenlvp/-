package com.personal.application.mapper;

import com.personal.application.dto.CollectionDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CollectionMapper {
    @Insert("<script>" +
            "INSERT INTO collection ( user_id, news_id, is_collect )\n" +
            "VALUES\n" +
            "\t( #{userId}, #{newsId}, 0 )" +
            "</script>")
    Integer addCollection(@Param("newsId") Integer newsId,
                     @Param("userId") String userId);


    @Select("<script>" +
            "select \n" +
            "case count(is_collect) \n" +
            "when is_collect=0 then 0\n" +
            "when is_collect=1 then 1\n" +
            "else  2\n" +
            "end as collect\n" +
            "        from collection \n" +
            "        where user_id = #{userId}\n" +
            "        and news_id =#{newsId}" +
            "</script>")
    Integer getCollectionById(@Param("newsId") Integer newsId,
                         @Param("userId") String userId);

    @Insert("<script>" +
            "UPDATE collection \n" +
            "SET is_collect = #{collectFlg} \n" +
            "WHERE\n" +
            "\tnews_id = #{newsId} and" +
            "\tuser_id = #{userId}" +
            "</script>")
    Integer updateCollectFlg(@Param("newsId") Integer newsId,
                           @Param("userId") String userId,
                           @Param("collectFlg") Integer collectFlg);

    @Select("<script>" +
            " SELECT\n" +
            "\tt.* \n" +
            "FROM\n" +
            "\t(\n" +
            "SELECT\n" +
            "\td.dict_name AS 'newsTypeName',\n" +
            "\tc.news_id,\n" +
            "\tn.title,\n" +
            "\tu.user_name,\n" +
            "\tc.create_time \n" +
            "FROM\n" +
            "\tcollection c\n" +
            "\tLEFT JOIN news n ON c.news_id = n.news_id\n" +
            "\tLEFT JOIN user_info u ON n.user_id = u.user_id\n" +
            "\tLEFT JOIN dict d ON d.dict_value = n.news_type \n" +
            "\tAND d.dict_type = 'news' \n" +
            "WHERE\n" +
            "\tc.user_id = #{userId} \n" +
            " <if test=' newsType !=null'>" +
            " and n.news_type = #{newsType}" +
            "</if>" +
            "ORDER BY\n" +
            "\tcreate_time DESC \n" +
            "\tLIMIT #{startRow},#{pageSize}\n" +
            "\t) t UNION ALL\n" +
            "SELECT\n" +
            "\tcount( c.news_id ),\n" +
            "\tc.news_id,\n" +
            "\tn.title,\n" +
            "\tu.user_name,\n" +
            "\tc.create_time \n" +
            "FROM\n" +
            "\tcollection c\n" +
            "\tLEFT JOIN news n ON c.news_id = n.news_id\n" +
            "\tLEFT JOIN user_info u ON n.user_id = u.user_id\n" +
            "\tLEFT JOIN dict d ON d.dict_value = n.news_type \n" +
            "\tAND d.dict_type = 'news' \n" +
            "WHERE\n" +
            "\tc.user_id = #{userId}" +
            " <if test=' newsType !=null'>" +
            " and n.news_type = #{newsType}" +
            "</if>" +
            "</script>")
    List<CollectionDto> findCollectionByUserId( CollectionDto collectionDto);
}

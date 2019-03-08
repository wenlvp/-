package com.personal.application.mapper;

import com.personal.application.pojo.Dict;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DictMapper {
    @Select("<script>" +
            "select dict_value,dict_name\n" +
            "from dict\n" +
            "where dict_type = #{dictType}" +
            "</script>")
    List<Dict> getDict(@Param("dictType") String dictType);
}

package com.personal.application.mapper;

import com.personal.application.pojo.EmpMst;
import com.personal.application.pojo.Privilege;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RoleMapper {
    @Select("<script>" +
            "select a.module_code,b.module_name,a.menu_code,a.menu_name,a.menu_group\n" +
            "from menu_mst a\n" +
            "left join \n" +
            " module_mst b\n" +
            "on a.module_code=b.module_code\n" +
            "order by\n" +
            "a.module_code,a.menu_group" +
            "</script>")
    List<Privilege> getPrivilegeList();

    @Select("<script>" +
            "select action_flg from emp_mst\n" +
            "where role_id = #{roleId}\n" +
            "and menu_code = #{menuCode}" +
            "</script>")
    @Results({@Result(column = "action_flg",property = "actionFlg")})
    EmpMst getActionFlgBy(@Param("roleId") String roleId,
                          @Param("menuCode") String menuCode);
    @Insert("<script>" +
            "insert into emp_mst \n" +
            "(role_id,menu_code,action_flg)\n" +
            "values(#{roleId},#{menuCode},'0')" +
            "</script>")
    int addEmpMst(@Param("roleId") String roleId,
                  @Param("menuCode") String menuCode);
    @Update("<script>" +
            "update emp_mst\n" +
            "set\n" +
            "action_flg = #{actionFlg}\n" +
            "where role_id = #{roleId}\n" +
            "and menu_code= #{menuCode}" +
            "</script>")
    int updateEmpMst(@Param("roleId") String roleId,
                     @Param("menuCode") String menuCode,
                     @Param("actionFlg") String actionFlg);
    @Update("<script>" +
            "update emp_mst\n" +
            "set\n" +
            "action_flg = '1'\n" +
            "where role_id = #{roleId}" +
            "</script>")
    void updateAllActionFlgByRoleId(@Param("roleId") String roleId);
    @Select("<script>" +
            "select * from emp_mst\n" +
            "            where action_flg = '0' \n" +
            "             and role_id= #{roleId}" +
            "</script>")
    List<EmpMst> findMenuCodeBy(@Param("roleId") String roleId);
}

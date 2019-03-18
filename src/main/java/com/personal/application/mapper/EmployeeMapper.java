package com.personal.application.mapper;

import com.personal.application.pojo.Employee;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface EmployeeMapper {
    @Select("<script> " +
            "select e.emp_id,e.emp_name,e.password,r.role_name role,e.phone,e.email " +
            "from employee e left join role r on e.role = r.role_id " +
            "where del_flg = 0" +
            "<if test='employee.getEmpId() !=null '>" +
            "and e.emp_id= '${employee.getEmpId()}'" +
            "</if> " +
            "<if test='employee.getEmpName() !=null '>" +
            "and e.emp_name like '%${employee.getEmpName()}%'" +
            "</if> " +
            "<if test='employee.getRole() !=null '>" +
            "and e.role= '${employee.getRole()}'" +
            "</if> " +
            //"</where>" +
            "</script>")
        //@Results({@Result(column = "role_name",property = "role")})
    List<Employee> findEmployeeBy(@Param("employee") Employee employee);
    @Update("<script> " +
            "update employee " +
            "set del_flg='1' " +
            "where emp_id= #{empId}" +
            "</script>" )
    boolean delEmployeeById(@Param("empId") String empId);
}

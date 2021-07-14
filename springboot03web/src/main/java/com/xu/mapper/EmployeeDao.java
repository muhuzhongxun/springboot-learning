package com.xu.mapper;

import com.xu.pojo.Department;
import com.xu.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

//员工Dao
@Repository
public class EmployeeDao {

    //模拟数据库中的数据
    private static Map<Integer, Employee> Employees = null;

    //员工有所属的部门
    @Autowired
    private DepartmentDao departmentDao;

    static{
        //创建一个员工表
        Employees = new HashMap<Integer,Employee>();

        Employees.put(101,new Employee(1001,"aa","983451135@qq.com",1,new Department(101,"后请部")));
        Employees.put(102,new Employee(1002,"aa","983451135@qq.com",1,new Department(101,"后请部")));
        Employees.put(103,new Employee(1003,"aa","983451135@qq.com",1,new Department(101,"后请部")));
        Employees.put(104,new Employee(1004,"aa","983451135@qq.com",1,new Department(101,"后请部")));
        Employees.put(105,new Employee(1005,"aa","983451135@qq.com",1,new Department(101,"后请部")));
        Employees.put(106,new Employee(1006,"aa","983451135@qq.com",1,new Department(101,"后请部")));
    }

}

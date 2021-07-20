package com.xu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JdbcController {

    @Autowired
    JdbcTemplate jdbcTemplate;


    //查询数据库所有信息
    // 没有实体类，数据库中的东西，怎么获取？    Map
    @GetMapping("/userList")
    public List<Map<String,Object>> userList(){
        String sql = "select * from kuang.user";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }

    @GetMapping("/addUser")
    public String addUser(){
        String sql = "insert into kuang.user(id,name,pwd) values(2,'小强','123456')";
        jdbcTemplate.execute(sql);
        return "insert_ok";
    }

    @GetMapping("/delUser/{id}")
    public String delUser(@PathVariable("id") int id){
        String sql = "delete from kuang.user where id= ?";
        jdbcTemplate.update(sql,id);
        return "del_ok";
    }

    @GetMapping("/upUser/{id}")
    public String upUser(@PathVariable("id") int id){
        String sql = "update kuang.user set name = ? ,pwd = ? where id = "+id;

        //封装
        Object[] objects = new Object[2];
        objects[0] = "小刘";
        objects[1] = "12345";
        jdbcTemplate.update(sql,objects);
        return "up_ok";
    }
}

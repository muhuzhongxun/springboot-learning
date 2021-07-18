package com.xu.mapper;

import com.xu.pojo.Member;
import com.xu.pojo.Role;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class RoleDao {
    private static Map<Integer, Role> roles = null;

    static{
        //创建一个会员表
        roles = new HashMap<Integer,Role>();

        roles.put(1,new Role(0,"普通用户"));
        roles.put(2,new Role(1,"会员"));
        roles.put(3,new Role(2,"超级会员"));
        roles.put(4,new Role(5,"管理员"));
        }

    //获得所有权限信息
    public Collection<Role> getRole(){
        return roles.values();
    }
}

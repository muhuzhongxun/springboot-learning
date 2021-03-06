package com.xu.mapper;

import com.xu.pojo.Member;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class MemberDao {
    //模拟数据库中的数据
    private static Map<Integer, Member> Members = null;

    static{
        //创建一个会员表
        Members = new HashMap<Integer,Member>();

        Members.put(1001,new Member(1001,"小明","123","983141546@qq.com",1,"13514852495","广东-东莞","",1,5));
        Members.put(1002,new Member(1002,"小红","123","983141546@qq.com",0,"13514852495","广东-东莞","",0,0));
        Members.put(1003,new Member(1003,"小白","123","983141546@qq.com",0,"13514852495","广东-东莞","",1,2));
        Members.put(1004,new Member(1004,"小驴","123","983141546@qq.com",1,"13514852495","广东-东莞","",0,1));
        Members.put(1005,new Member(1005,"小札","123","983141546@qq.com",1,"13514852495","广东-东莞","",1,0));
        Members.put(1006,new Member(1006,"小傻","123","983141546@qq.com",1,"13514852495","广东-东莞","",0,0));
    }

    //主键自增
    private static Integer intid = 1006;

    //获得所有会员信息
    public Collection<Member> getMembers(){
        return Members.values();
    }

    //通过id得到会员
    public Member getMemberById(Integer id){
        return Members.get(id);
    }

    //添加会员信息
    public void save(Member member){
        if (member.getId() == null){
            member.setId(intid++);
        }
        Members.put(member.getId(),member);
    }

    //删除指定id的会员信息
    public void remove(Integer intid){
        Members.remove(intid);
    }
    //批量删除会员信息

}

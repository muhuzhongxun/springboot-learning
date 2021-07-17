package com.xu.mapper;

import com.xu.pojo.Employee;
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

        Members.put(101,new Member(1001,"小明","123","983141546@qq.com",1,"13514852495","广东-东莞","",1,0));
        Members.put(102,new Member(1002,"小红","123","983141546@qq.com",1,"13514852495","广东-东莞","",1,0));
        Members.put(103,new Member(1003,"小白","123","983141546@qq.com",1,"13514852495","广东-东莞","",1,0));
        Members.put(104,new Member(1004,"小驴","123","983141546@qq.com",1,"13514852495","广东-东莞","",1,0));
        Members.put(105,new Member(1005,"小札","123","983141546@qq.com",1,"13514852495","广东-东莞","",1,0));
        Members.put(106,new Member(1006,"小傻","123","983141546@qq.com",1,"13514852495","广东-东莞","",1,0));
    }

    //主键自增
    private static Integer intid = 106;

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

}

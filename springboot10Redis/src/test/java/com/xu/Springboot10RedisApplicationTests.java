package com.xu;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.xu.Util.RedisUtil;
import com.xu.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class Springboot10RedisApplicationTests {

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void test1(){
        redisUtil.set("name","muhuzhonguxn");
        System.out.println(redisUtil.get("name"));
    }

    @Test
    void contextLoads() {

        //redisTemplate 操作不同的数据类型，api和指令时一样的
        //opsForValue 操作字符串 ，类似spring
        //opsForList 操作List ，类似List
        //opsForSet
        //opsForHash
        //opsForZSet
        //opsForGeo
        //opsForHyperLogLog

        //除了基本的操作，我们常用的方法都可以直接通过redistemplate操作，如事务，和基本的增删改查

        //获取redis的对象
        //        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
        //        connection.flushDb();
        //        connection.flushAll();


        redisTemplate.opsForValue().set("Mykey","muhuzhongxun");
        System.out.println(redisTemplate.opsForValue().get("Mykey"));

    }

    @Test
    public void test() throws JsonProcessingException {

        User user = new User("muhuzhongxun", 19);
        //真实的开发一般需要使用json来传递对象
        // String jsonUser = new ObjectMapper().writeValueAsString(user);
        redisTemplate.opsForValue().set("user",user);
        System.out.println(redisTemplate.opsForValue().get("user"));
    }
}

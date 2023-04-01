package com.shamengxin.reids.demo;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import io.lettuce.core.protocol.RedisCommand;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LettuceDemo {

    public static void main(String[] args) {

        //1. 使用构建器链式编程来builder我们redisURI
        RedisURI uri = RedisURI.builder().redis("192.168.108.129")
                .withPort(6379)
                .withAuthentication("default","111111")
                .build();

        //2. 创建连接客户端
        RedisClient redisClient = RedisClient.create(uri);
        StatefulRedisConnection connect = redisClient.connect();

        //3. 通过conn创建操作的command
        RedisCommands commands = connect.sync();

        //=========================================
        //keys
        List keys = commands.keys("*");
        keys.forEach(System.out::println);

        //string
        commands.set("k1","1111");
        System.out.println(commands.get("k1"));

        //list
        commands.lpush("myList","v1","v2","v3");
        List myList = commands.lrange("myList", 0, -1);
        myList.forEach(System.out::println);

        //set
        commands.sadd("mySet","v1","v2","v3");
        Set mySet = commands.smembers("mySet");
        for (Object o : mySet) {
            System.out.println(o);
        }

        //hash
        Map<String,String> map = new HashMap<>();
        map.put("k1","22222222");
        map.put("k2","shamengxin");
        commands.hmset("myHash",map);

        //zset
        commands.zadd("myZset",10.0,"s1",20.0,"s2",20.0,"s3");
        List myZset = commands.zrange("myZset", 0L, -1L);
        myZset.forEach(System.out::println);


        //=========================================

        //4.关闭释放资源
        connect.close();
        redisClient.shutdown();

    }

}

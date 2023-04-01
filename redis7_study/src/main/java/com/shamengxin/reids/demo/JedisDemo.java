package com.shamengxin.reids.demo;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JedisDemo {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.108.129", 6379);

        jedis.auth("111111");

        System.out.println(jedis.ping());

        //keys
        Set<String> keys = jedis.keys("*");
        System.out.println(keys);

        System.out.println("jedis.exists=====>"+jedis.exists("k2"));

        //string
        jedis.set("k1","hello,jedis");
        System.out.println(jedis.get("k3"));
        System.out.println(jedis.ttl("k3"));
        jedis.expire("k3",20L);

        System.out.println("-----------------------------------");
        jedis.mset("str1","v1","str2","v2","str3","v3");
        System.out.println(jedis.mget("str1","str2","str3"));

        //list
        jedis.lpush("list1","4","4","3","8");
        List<String> list = jedis.lrange("list1", 0, -1);
        for (String s : list) {
            System.out.println(s);
        }

        System.out.println("---------------set------------------------");
        jedis.sadd("orders","jd001");
        jedis.sadd("orders","jd002");
        jedis.sadd("orders","jd003");
        Set<String> set = jedis.smembers("orders");
        for (String s : set) {
            System.out.println(s);
        }
        jedis.srem("orders","jd002");
        System.out.println(jedis.smembers("orders").size());

        System.out.println("----------------hash----------------------");
        jedis.hset("hash1","userName","list");
        System.out.println(jedis.hget("hash1","userName"));
        Map<String,String> map = new HashMap<String,String>();
        map.put("phone","000000");
        map.put("address","shamengxin");
        jedis.hmset("hash2", map);
        List<String> hmget = jedis.hmget("hash2", "phone", "address");
        for (String s : hmget) {
            System.out.println(s);
        }

        System.out.println("-------------zset----------------");
        jedis.zadd("zset01",60,"v1");
        jedis.zadd("zset01",70,"v2");
        jedis.zadd("zset01",80,"v3");
        jedis.zadd("zset01",90,"v4");
        List<String> zset01 = jedis.zrange("zset01", 0, -1);
        zset01.forEach(System.out::println);

    }

}

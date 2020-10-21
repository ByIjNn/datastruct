package com.binblink.redis;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.HashMap;
import java.util.Map;

public class JedisDemo {

    public static void main(String[] args) {

        HostAndPort hostAndPort = new HostAndPort("192.168.1.8",6379);

        Jedis jedis = new Jedis(hostAndPort);

        Map<String, String> map = new HashMap<>();
        map.put("a","23");
        map.put("b","11");
        map.put("c","32");

        System.out.println(jedis.ping());

        jedis.hset("map",map);

        System.out.println(jedis.hgetAll("map"));
        System.out.println(jedis.hkeys("map"));

        Transaction transaction = jedis.multi();
        transaction.set("v2","45");
        transaction.incrBy("v2",15);
        transaction.set("email","www@.com");

        transaction.incr("email");
        transaction.incr("v2");
        transaction.decr("v3");

        transaction.exec();
//        transaction.exec();
//        transaction.discard();
//        int i = 1/0;
//        transaction.close();

    }
}

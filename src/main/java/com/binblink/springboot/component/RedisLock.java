package com.binblink.springboot.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

//@Component
public class RedisLock {


    @Autowired
    private RedisUtil redisUtil;

    private static volatile int count = 0;
    private static volatile int failRetryTimes = 10;

//    public boolean lock(String key, V v, int expireTime){
//        int retry = 0;
//        //获取锁失败最多尝试10次
//        while (retry < failRetryTimes){
//            //1.先获取锁,如果是当前线程已经持有，则直接返回
//            //2.防止后面设置锁超时，其实是设置成功，而网络超时导致客户端返回失败，所以获取锁之前需要查询一下
//            String value = (String) redisUtil.get(key);
//            //如果当前锁存在，并且属于当前线程持有，则锁计数+1，直接返回
//            if (null != value && value.equals(v)){
//                count ++;
//                return true;
//            }
//
//            //如果锁已经被持有了，那需要等待锁的释放
//            if (value == null || count <= 0){
//                //获取锁
//                Boolean result = redis.setNx(key, v, expireTime);
//                if (result){
//                    count = 1;
//                    return true;
//                }
//            }
//
//            try {
//                //获取锁失败间隔一段时间重试
//                TimeUnit.MILLISECONDS.sleep(sleepInterval);
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//                return false;
//            }
//
//        }
//
//        return false;
//    }
//    public boolean unlock(String key, String requestId){
//        String value = redis.get(key);
//        if (Strings.isNullOrEmpty(value)){
//            count = 0;
//            return true;
//        }
//        //判断当前锁的持有者是否是当前线程，如果是的话释放锁，不是的话返回false
//        if (value.equals(requestId)){
//            if (count > 1){
//                count -- ;
//                return true;
//            }
//
//            boolean delete = redis.delete(key);
//            if (delete){
//                count = 0;
//            }
//            return delete;
//        }
//
//        return false;
//    }
//
//    public static void main(String[] args) {
//        Integer productId = 324324;
//        RedisLock<String> redisLock = new RedisLock<String>();
//        String requestId = UUID.randomUUID().toString();
//        redisLock.lock(productId+"", requestId, 1000);
//    }

}

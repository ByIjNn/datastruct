package com.binblink.javase.Thread.ThreadApplicationDemo;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * @author:binblink
 * @Description 具有超时连接的 数据库连接池 模拟
 * @Date: Create on  2018/10/19 0:16
 * @Modified By:
 * @Version:1.0.0
 **/
public class ConnectionPool {

    private LinkedList<Connection> pool = new LinkedList<Connection>();

    //初始化池
    public ConnectionPool(int initSize) {
        for (int i = 0; i < initSize; i++) {
            pool.addLast(ConnectionDriver.createConnection());
        }
    }

    //超时等待模式获取
    public Connection getConnection(long mills) throws InterruptedException {
        synchronized (pool) {
            if (mills < 0) {
                while (pool.isEmpty()) {
                    pool.wait();
                }

                return pool.removeFirst();
            } else {
                long future = System.currentTimeMillis() + mills;
                long remaining = mills;

                while (pool.isEmpty() && remaining > 0) {
                    pool.wait(remaining);
                    remaining = future - System.currentTimeMillis();
                }
                Connection result = null;

                if (!pool.isEmpty()) {
                    result = pool.removeFirst();
                }
                return result;
            }

        }
    }

    public void releaseConnection(Connection connection) {
        if (connection != null) {
            synchronized (pool) {
                // 连接释放后需要进行通知，这样其他消费者能够感知到连接池中已经归还了一个连接
                pool.addLast(connection);
                pool.notifyAll();

            }
        }
    }

    // 在mills内无法获取到连接，将会返回null
//    public Connection fetchConnection(long mills) throws InterruptedException {
//        synchronized (pool) {
//        // 完全超时
//            if (mills <= 0) {
//                while (pool.isEmpty()) {
//                    pool.wait();
//                }
//                return pool.removeFirst();
//            } else {
//                long future = System.currentTimeMillis() + mills;
//                long remaining = mills;
//                while (pool.isEmpty() && remaining > 0) {
//                    pool.wait(remaining);
//                    remaining = future - System.currentTimeMillis();
//                }
//                Connection result = null;
//                if (!pool.isEmpty()) {
//                    result = pool.removeFirst();
//                }
//                return result;
//            }
//        }
//    }



}

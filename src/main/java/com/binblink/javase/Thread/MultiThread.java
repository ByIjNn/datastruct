package com.binblink.javase.Thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @author:binblink
 * @Description 获取线程信息
 * @Date: Create on  2020/10/2 9:47
 * @Modified By:
 * @Version:1.0.0
 **/
public class MultiThread {

    public static void main(String[] args) {
//        Thread
        // 获取Java线程管理MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        // 不需要获取同步的monitor和synchronizer信息，仅获取线程和线程堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        // 遍历线程信息，仅打印线程ID和线程名称信息
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("[" + threadInfo.getThreadId() + "] " + threadInfo.
                    getThreadName());
        }
    }
}

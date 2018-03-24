package com.yema1.E_ThreadPool;

/**
 * @Author：yema
 * @Description：
 * @Date：Create in 17:04 2018/3/23
 * @Edit：by Intellij IDEA
 */
public class ThreadPoolRunable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"---线程提交的任务");
    }
}

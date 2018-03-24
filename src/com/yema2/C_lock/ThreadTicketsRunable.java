package com.yema2.C_lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author：yema
 * @Description：  首先，我们都知道在线程里面sleep();是可能会出现异常的，一旦发生了异常线程中断执行，如果个代码是在同步块中，无论是否捕获异常，对象锁都不会释放。
 * ·                因此，使用jdk1.5的接口Lock来替换synchronized同步代码块，实现线程安全性（Lock接口在java.util.concurrent.locks包下）
 *                  Lock接口的方法：lock();/unlock():分别是获取/释放锁。
 *                  实现类：ReentrantLock
 * @Date：Create in 17:56 2018/3/23
 * @Edit：by Intellij IDEA
 */
public class ThreadTicketsRunable implements Runnable {

    //定义可以出售的票源
    private int total = 100;

    //在类的成员位置，创建Lock接口的实现类对象
    private Lock lock = new ReentrantLock();

    /**
     * 下面写了两处释放锁，就是为了保证线程无论如何都必须把锁释放掉
     */
    @Override
    public void run() {
        while (true){

            //调用Lock接口的方法lock()获取锁
            lock.lock();

            //如果总数大于0，可以出售
            if (total > 0){
                try {
                    Thread.sleep(10);
                    System.out.println(Thread.currentThread().getName()+"---出售第"+total--);
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    //释放锁，调用Lock接口方法unlock()
                    lock.unlock();
                }
            }else {
                System.err.println(Thread.currentThread().getName()+"---没票了"+total);
                //先释放锁再break;，否则锁一直不释放，线程就一直不会结束
                lock.unlock();
                break;
            }
        }
    }
}

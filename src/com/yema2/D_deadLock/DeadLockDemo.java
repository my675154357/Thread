package com.yema2.D_deadLock;

/**
 * @Author：yema
 * @Description：
 * @Date：Create in 10:49 2018/3/24
 * @Edit：by Intellij IDEA
 */
public class DeadLockDemo {
    public static void main(String[] args) {
        ThreadDeadLock dl = new ThreadDeadLock();
        new Thread(dl).start();
        new Thread(dl).start();
    }
}

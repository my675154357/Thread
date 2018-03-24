package com.yema2.D_deadLock;

/**
 * @Author：yema
 * @Description： 死锁例子
 * @Date：Create in 10:40 2018/3/24
 * @Edit：by Intellij IDEA
 */
public class ThreadDeadLock implements Runnable {

    private boolean flag = true;

    @Override
    public void run() {
        while (true){
            if (flag){
                //先进A同步，再进B同步
                synchronized (LockA.lockA){
                    System.out.println("if.....lockA");
                    synchronized (LockB.lockB){
                        System.out.println("if....lockB");
                    }
                }
            }else{
                //先进B同步，再进A同步
                synchronized (LockB.lockB){
                    System.err.println("else....lockB");
                    synchronized (LockA.lockA) {
                        System.err.println("else.....lockA");
                    }
                }
            }
            flag = !flag;
        }
    }
}

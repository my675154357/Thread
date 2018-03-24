package com.yema1.C_runable;

/**
 * @Author：yema
 * @Description： 实现runable接口实现线程
 * @Date：Create in 9:37 2018/3/23
 * @Edit：by Intellij IDEA
 */
public class SubRunable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++){
            try {
                //sleep()方法可能会出现异常，但无论是继承Thread还是实现runable的方式实现线程都不能抛出异常只能捕获，因为Thread和runable中均为抛出异常，子类和实现类是不能抛的
                Thread.sleep(1000);
                System.out.println("run..." + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

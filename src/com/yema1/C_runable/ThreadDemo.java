package com.yema1.C_runable;

/**
 * @Author：yema
 * @Description： 创建Thread类对象，构造方法这种，传入Runnable接口实现类。调用Thread类方法的start();
 * @Date：Create in 9:36 2018/3/23
 * @Edit：by Intellij IDEA
 */
public class ThreadDemo{
    public static void main(String[] args) {
        SubRunable sr = new SubRunable();
        Thread t = new Thread(sr);
        t.start();
    }
}

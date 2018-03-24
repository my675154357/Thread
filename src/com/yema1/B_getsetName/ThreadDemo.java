package com.yema1.B_getsetName;

/**
 * @Author：yema
 * @Description： 每个线程都有自己的名字
 *                  运行方法mian()的名字就是“main”。其他新建线程的名字默认就是“Thread-0,-1,-2...”
 *                  jvm开启主线程运行方法mian，主线程也是线程，必然是Thraed对象。Thread类中定义了一个静态方法,static currentThread();，返回正在执行的线程对象。
 * @Date：Create in 17:45 2018/3/22
 * @Edit：by Intellij IDEA
 */
public class ThreadDemo{
    public static void main(String[] args) {
        NameThread t = new NameThread();
        t.setName("nameThread");
        t.start();
        System.out.println(Thread.currentThread().getName());
    }
}

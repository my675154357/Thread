package com.yema1.B_getsetName;

/**
 * @Author：yema
 * @Description：
 * @Date：Create in 17:47 2018/3/22
 * @Edit：by Intellij IDEA
 */
public class NameThread extends Thread{
    public void run(){
        //获取线程名，getName(); Thread.currentThread().getName(); 都是获取当前线程对象的名字
        System.out.println(getName());
        System.out.println(Thread.currentThread().getName());
    }
}

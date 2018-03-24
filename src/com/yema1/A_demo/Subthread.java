package com.yema1.A_demo;

/**
 * @Author：yema
 * @Description： 定义子类，继承Thread，重写run()方法
 * @Date：Create in 17:05 2018/3/22
 * @Edit：by Intellij IDEA
 */
public class Subthread extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 50; i++){
            System.out.println("sub.."+i);
        }
    }
}

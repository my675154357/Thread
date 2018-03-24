package com.yema2.E_waitAndNotify;

/**
 * @Author：yema
 * @Description： 开启输入线程和输出线程，实现赋值和打印值
 * @Date：Create in 11:30 2018/3/24
 * @Edit：by Intellij IDEA
 */
public class IndexDemo {
    public static void main(String[] args) {
        Resource r = new Resource();
        Input in = new Input(r);
        Output out = new Output(r);
        new Thread(in).start();
        new Thread(out).start();
    }
}

package com.yema2.A_demo;

/**
 * @Author：yema
 * @Description： 多线程并发访问同一个数据资源。三个线程，对同一个票源出售
 * @Date：Create in 17:55 2018/3/23
 * @Edit：by Intellij IDEA
 */
public class ThreadDemo {
    public static void main(String[] args) {
//        new Thread(new ThreadTicketsRunable()).start();
//        new Thread(new ThreadTicketsRunable()).start();
//        new Thread(new ThreadTicketsRunable()).start();

        //注意，上面那种执行结果和下面这种可不一样。看出问题了：上面的ThreadTicketsRunable是三个不同的对象，那么写就不是一个意思了。要注意这个问题
        ThreadTicketsRunable t = new ThreadTicketsRunable();
        new Thread(t).start();
        new Thread(t).start();
        new Thread(t).start();
    }
}

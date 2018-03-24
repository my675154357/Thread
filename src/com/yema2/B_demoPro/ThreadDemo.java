package com.yema2.B_demoPro;

/**
 * @Author：yema
 * @Description： 仍然是上一个例子，这次采用同步方法的形式，解决线程安全问题
 *                  好处：简洁，代码量少
 *                  将线程共享数据和同步代码，抽取到一个方法中
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

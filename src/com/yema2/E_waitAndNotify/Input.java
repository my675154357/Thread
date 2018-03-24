package com.yema2.E_waitAndNotify;

/**
 * @Author：yema
 * @Description： 输入线程，对Resource中的变量赋值
 * @Date：Create in 11:23 2018/3/24
 * @Edit：by Intellij IDEA
 */
public class Input implements Runnable {

    //共享数据
    private Resource r;

    public Input(Resource r){
        this.r = r;
    }

    @Override
    public void run() {
        boolean flag = true;
        while (true){
            synchronized (r){
                //标记true是等待
                if (r.flag){
                    try {
                        //注意要用对象锁来调用，否则就是父类调用的这个方法，而wait()方法是Object类的，这样一来就不是同一个锁了。
                        r.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (flag){
                    r.name = "小明";
                    r.sex = "男";
                }else {
                    r.name = "小花";
                    r.sex = "女";
                }
                //标记取反，并唤醒对方线程
                r.flag = true;
                r.notify();
            }
            flag = !flag;
        }
    }
}

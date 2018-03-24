package com.yema2.E_waitAndNotify;

/**
 * @Author：yema
 * @Description： 输入线程，对Resource中的变量取值
 * @Date：Create in 11:23 2018/3/24
 * @Edit：by Intellij IDEA
 */
public class Output implements Runnable {

    //共享数据
    private Resource r;

    public Output(Resource r){
        this.r = r;
    }

    @Override
    public void run() {
        boolean flag = true;
        while (true){
            synchronized (r){
                //标记为false，等待
                if (!r.flag){
                    try {
                        r.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(r.name+"..."+r.sex);
                //标记取反，并唤醒对方线程
                r.flag = false;
                r.notify();
            }
        }
    }
}

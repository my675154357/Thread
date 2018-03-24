package com.yema2.A_demo;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * @Author：yema
 * @Description： 通过线程休眠，发现了线程安全问题。因此sun公司提供了同步技术：synchronized(任意对象){线程压要操作的共享数据}
 *                  叫做同步代码块。但线程安全了，速度也就下来了（加了同步后，线程进同步需要：判断锁、获取锁。出同步需要：释放锁）会耗费资源。这两者根据需求做取舍
 * @Date：Create in 17:56 2018/3/23
 * @Edit：by Intellij IDEA
 */
public class ThreadTicketsRunable implements Runnable {

    /**
     * 这里我想讲两句：这是个线程安全问题的例子。
     * 1.首先，如果total变量没用static修饰，那么三个线程就会各自拥有一个total变量，就会有三个100往下减。但总总数100只有一个，这很明显是不对的。
     * 2.加了static，共享同一个total变量，这下虽然只会有一个100往下减，但是多运行几次是会发现问题的。假如此时只剩下一张票了，由于CPU调度是随机不可控的，
     * 三个线程完全可能同时进入到了if判断里面，线程0进行了total--，此时total就是0。此时CPU调度执行到了线程1，也去total--，那total就是-1了。同理，到了线程2，total就是-2.
     * 这也是肯定不可以的。由于CPU资源随机调度，这种情况执行一两次可能不会发生，但随着执行次数的增多，问题就会暴露出来。
     */

    /**
     * 解决思路：
     * 当一个线程进入数据操作的时候，在没完成操作之前，其他线程只能等待。就像一个通道，如果一个人进去了，再他没出去之前，无论这个人在里面停留了多久，做了什么，
     * 其他人都不能挤进来。只有这个人离开了通道，其他人才能进来。
     */

    //定义可以出售的票源
    private int total = 100;
    private Object obj = new Object();

    @Override
    public void run() {
        while (true){
            //因为可以传入任意对象，那这里就传入个obj。注意：这里可不能用匿名对象new Object()写在这里，编译不会报错，但是运行是有问题的，每次执行的时候都会创建对象，
            // 就不是同一个对象了。obj这个对象称为“同步锁”，也叫做“对象监视器”。
            //同步安全保证的原因：没有锁的线程不能执行，只能等待。
            //this本类引用，这里写上面的obj效果也是一样的。
            synchronized (this){
                //如果总数大于0，可以出售
                if (total > 0){
                    try {
                        //这里停顿一下，目的是给其他线程执行的机会，可以更容易的看出问题
                        //根据执行的结果来看，恰好说明了：Thread.sleep();方法不会放弃同步锁。但线程sleep的时候，其他线程是有机会获取CPU资源运行的，只是走到同步代码块，
                        //没有同步锁，不能执行同步代码。同步锁可以理解为一把钥匙或者通行证，持有才可以通行。
                        //Thread.sleep(10);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"---出售第"+total--);
                }else {
                    System.err.println(Thread.currentThread().getName()+"---没票了"+total);
                    break;
                }
            }
        }
    }
}

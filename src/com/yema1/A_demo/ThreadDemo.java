package com.yema1.A_demo;

/**
 * @Author：yema
 * @Description： 创建和启动一个线程。
 *                  创建Thread对象，子类对象调用start()方法，使虚拟机开始执行该线程并调用线程类中的run()方法。start()方法只能启动一次。
 * @Date：Create in 15:01 2018/3/22
 * @Edit：by Intellij IDEA
 */
public class ThreadDemo {

    public static void main(String[] args) {
        Subthread st = new Subthread();
        //new Thread(st).start();
        st.start();
        /*\
            思考：st.start();直接这样 子线程.start()开启和new Thread(st).start();这样传入子线程对象，通过Thread对象开启。有什么区别？
            answer：明白为什么会有两种写法了。原因在于：
                     start()方法是Thread类的，如果通过继承Thread类来实现一个线程可以直接用子类对象调用start()方法来创建并开启一个线程；
                     但如果是通过实现runable接口来实现线程，就不能用子类调用start()方法了，因为runable接口中没有定义start()方法，所以就
                     只能new 一个Thread对象，将子线程对象传入，通过Thread对象的start()方法创建并开启子线程。
             tip：趁现在还记得，再写一点东西给日后的自己提个醒。
                    通过java api文档可以看出，Thread类实际上是实现runable接口的，runable接口中仅有一个run()抽象方法。

             实现runable的原理：
              实现runable接口，避免了Thread类单继承的局限性。通过实现runable中的run()方法，直接将线程任务需要执行的代码定义到了run()中。
              只有创建Thread类才可以创建线程，而线程任务已经被封装到了runable的run()方法中，而这个run()方法是属于runable的实现类对象的，所以将这个实现类对象作为参数传递给
              Thread的构造方法，这样，线程在创建时就可以明确要执行的线程任务了。

              实现runable的好处（3点）：
              1.首先避免了单继承的局限性，所以常用。2.而实现runable的方式更加符合面向对象。线程分为两个部分，一个部分是线程对象，一部分是线程任务。将线程单独分离出来封装成对象，
              类型就是runable接口类型，这样可以实现线程对象和线程任务的解耦合。随时可以传入不同的实现类对象来开启不同的线程。3.还可以实现资源共享。
              而继承Thread类型，一旦创建子类线程对象，既是线程对象，又有线程任务，耦合度较高。一旦想开启不同的线程就必须改代码，new 新的子线程对象才能开启。

              tip：写代码都是注重高内聚，低耦合：高内聚通俗的讲就是自己的事情自己做，尽量避免依赖第三方，这样就不会受制于人；低耦合就是降低类与类之间的联系，
              实现某一方替换互不干扰。而实现接口恰恰就是体现这一特点的，这是接口的优势。
        */
    }
}

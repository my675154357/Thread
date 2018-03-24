package com.yema1.D_anonInnerClass;

/**
 * @Author：yema
 * @Description： 使用匿名内部类实现多线程。就是直接在父类或接口中实现run()方法吗，不写子类或实现类。好处就是节省代码，缺点就是格式不好阅读。
 *                  前提：必须继承或实现接口
 *                  new 父类或接口(){
 *                      重写抽象方法
 *                  }
 * @Date：Create in 10:28 2018/3/23
 * @Edit：by Intellij IDEA
 */
public class ThreadDemo {
    public static void main(String[] args) {
        //继承方式
        new Thread(){
            @Override
            public void run() {
                System.out.println("!!!");
            }
        }.start();;

        //实现接口方式
        Runnable r = new Runnable(){
            @Override
            public void run() {
                System.out.println("###");
            }
        };
        new Thread(r).start();;

        //合到一起写
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("@@@");
            }
        }).start();
    }
}

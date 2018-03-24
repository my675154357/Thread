package com.yema2.E_waitAndNotify;

/**
 * @Author：yema
 * @Description： 定义一个资源类。同时有2个线程对资源中的变量操作
 * @Date：Create in 11:09 2018/3/24
 * @Edit：by Intellij IDEA
 */
public class Resource {
    //为了演示，这里属性不能用private修饰
    public String name;
    public String sex;
    public boolean flag = false;
}

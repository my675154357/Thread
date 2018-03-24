package com.yema2.D_deadLock;

/**
 * @Author：yema
 * @Description：
 * @Date：Create in 10:34 2018/3/24
 * @Edit：by Intellij IDEA
 */
public class LockA {

    //将构造器修饰为私有，避免在其他类中被随便new
    private LockA(){};

    //而在本类中创建好本类对象，并设置成静态属性，其他类可以直接调用而不创建对象，同时又加了final修饰，在保证这个对象是唯一的同时，保证对象不会被修改
    public static final LockA lockA = new LockA();
}

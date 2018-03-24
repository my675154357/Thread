package com.yema1.E_ThreadPool;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author：yema
 * @Description：
 * @Date：Create in 16:19 2018/3/23
 * @Edit：by Intellij IDEA
 */
public class ThreadPool {

    /**
     * jdk5新特性，实现线程池程序
     * 使用Executors的静态方法创建线程池对象
     * @throws Exception
     */
    @Test
    public void fun1() throws Exception{
        //调用工厂类的静态方法，创建线程池对象，参数表示初始化线程的个数，返回项目层次对象，是一个接口实现类。
        ExecutorService es = Executors.newFixedThreadPool(2);
        //调用接口实现类对象es的submit方法提交线程任务。传递一个线程类
        es.submit(new ThreadPoolRunable());

        //提交线程任务的方法submit()，将返回一个Furture接口的实现类
        Future<String> f = es.submit(new ThreadPoolCallable());
        //通过get()方法获取线程的返回值，这里可能会出异常
        System.out.println(f.get());

        //销毁线程池，一般不用
        es.shutdown();
    }

    /**
     * 使用多线程技术异步计算，求和（线程池+Callable来做）
     * 两个线程：一个1+...+100；第二个1+...+200.两个求和
     */
    @Test
    public void fun2() throws Exception{
        ExecutorService es = Executors.newFixedThreadPool(2);
        Future<Integer> f100 = es.submit(new ThreadSum(100));
        Future<Integer> f200 = es.submit(new ThreadSum(200));
        System.out.println(f100.get());
        System.out.println(f200.get());
        System.out.println(f100.get()+f200.get());
        es.shutdown();
    }
}

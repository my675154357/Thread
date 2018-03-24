package com.yema1.E_ThreadPool;

import java.util.concurrent.Callable;

/**
 * @Author：yema
 * @Description： 实现线程的第三个方式，实现Callable接口。
 *                  实现步骤：1.工厂类创建线程池。2.调用submit提交方法任务
 * @Date：Create in 17:17 2018/3/23
 * @Edit：by Intellij IDEA
 */
public class ThreadPoolCallable implements Callable<String>{
    //父类中call()方法是抛了异常，但子类，可抛可不抛
    @Override
    public String call() {
        return "abc";
    }
}

package com.yema1.E_ThreadPool;

import java.util.concurrent.Callable;

/**
 * @Author：yema
 * @Description：
 * @Date：Create in 17:39 2018/3/23
 * @Edit：by Intellij IDEA
 */
public class ThreadSum implements Callable<Integer> {

    private int num;

    public ThreadSum(int num){
        this.num = num;
    }
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= num; i++){
            sum += i;
        }
        return sum;
    }
}

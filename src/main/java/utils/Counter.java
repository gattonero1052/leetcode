package utils;

/**
 * Created by zly on 2018/2/7.
 */
public class Counter{
    public static void count(Runnable app) {
        System.out.println("开始计时...");
        Long timer = System.currentTimeMillis();
        app.run();
        System.out.println("函数耗时 "+(System.currentTimeMillis()-timer)+" ms.");
        System.out.println();
    }
}

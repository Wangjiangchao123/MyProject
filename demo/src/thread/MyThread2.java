package thread;

import java.util.concurrent.Callable;

/**
 * @Author 王江超
 * @Date 2020/1/15 11:45
 * @Description:
 */
public class MyThread2 implements Callable {

    @Override
    public Object call() throws Exception {
        System.out.println("这是callable执行的");

        return "callable";
    }
}

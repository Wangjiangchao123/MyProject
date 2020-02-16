package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Author 王江超
 * @Date 2020/1/15 11:39
 * @Description:
 */
public class Test {

    public static void main(String[] args) {

        //继承Thread
        MyThread myThread = new MyThread();
        myThread.start();

        //实现runnable
        Thread thread = new Thread(new MyThread1());
        thread.start();

        //实现Callable  返回Object类型的
        Callable oneCallable = new MyThread2();
        FutureTask<Object> oneTask = new FutureTask<Object>(oneCallable);
        Thread thread1 = new Thread(oneTask);
        thread1.start();



    }



}

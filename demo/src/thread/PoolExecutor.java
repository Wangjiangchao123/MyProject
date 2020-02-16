package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author 王江超
 * @Date 2020/1/15 14:03
 * @Description:
 */
public class PoolExecutor {

    //线程池数量
    private static int POOL_NUM = 10;


    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for(int i = 0; i<POOL_NUM; i++)
        {
            RunnableThread thread = new RunnableThread();

            //Thread.sleep(1000);
            executorService.execute(thread);
        }
        //关闭线程池
        executorService.shutdown();
    }


}
class RunnableThread implements Runnable
{
    @Override
    public void run()
    {
        System.out.println("通过线程池方式创建的线程：" + Thread.currentThread().getName() + " ");

    }
}

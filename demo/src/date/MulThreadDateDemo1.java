package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 多线程下的字符串转日期
 */
public class MulThreadDateDemo1 {

    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                //单一线程下  实现字符串转日期处理
                try {
                    System.out.println("【"+Thread.currentThread().getName()+"】"+sdf.parse("1988-02-17 21:55:32"));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            },"SDF转线程"+i).start();
        }


    }
}

package date;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 多线程下的字符串转日期 localTime
 */
public class MulThreadDateDemo2 {

    public static void main(String[] args) {
        //日期时间格式化对象
        DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //获取当前的时区ID
        ZoneId zoneId = ZoneId.systemDefault();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                //单一线程下  实现字符串转日期处理
                LocalDateTime localDateTime = LocalDateTime.parse("1988-02-17 21:55:32", sdf);
                //获取当前时区的实例
                Instant instant = localDateTime.atZone(zoneId).toInstant();
                Date from = Date.from(instant);//字符串转日期
                System.out.println("【" + Thread.currentThread().getName() + "】" + from);

            }, "SDF转线程" + i).start();
        }


    }
}

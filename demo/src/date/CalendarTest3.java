package date;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Locale;

/**
 * LocalTime
 */
public class CalendarTest3 {

    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat();


        //format   将Date转为字符串
        //parse    将字符串转为Date类型
        /**
         * y   ---   年
         * M   ---   月
         * dd  ---   日
         *
         * H   ---   时
         * mm  ---   分
         * ss  ---   秒
         * SSS ---  毫秒
         *
         */

        //Jdk1.8 之后新的时间处理包java.time   在这个包中提供三个主要的类型： LocalDate 、  LocalTime 、 LocalDateTime


        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);
    }


}

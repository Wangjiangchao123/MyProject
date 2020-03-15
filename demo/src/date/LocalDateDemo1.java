package date;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class LocalDateDemo1 {


    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println(String.format("【当前日期】%s-%s-%s",localDate.getYear(),localDate.getMonthValue(),localDate.getDayOfMonth()));
        System.out.println("获取一周的时间数"+localDate.getDayOfWeek().getValue());
        System.out.println("今天所处一周的时间数"+localDate.get(ChronoField.ALIGNED_WEEK_OF_MONTH));
        System.out.println("今天所处一年的周数"+localDate.get(ChronoField.ALIGNED_WEEK_OF_YEAR));
        System.out.println("今天所处一年的第几天"+localDate.getDayOfYear());
    }
}

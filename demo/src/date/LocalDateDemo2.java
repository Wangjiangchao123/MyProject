package date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class LocalDateDemo2 {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.parse("1988-09-15");
        System.out.println("闰年判断"+localDate.isLeapYear());
        System.out.println("所处的一周时间数"+localDate.getDayOfWeek());

        //获取所在月的第一天  最后一天
        System.out.println("所在月的第一天"+localDate.with(TemporalAdjusters.firstDayOfMonth()));
        System.out.println("所在月的第一天"+localDate.withDayOfMonth(1));

        //所在月的最后一天
        System.out.println("所在月的第一天"+localDate.with(TemporalAdjusters.lastDayOfMonth()));
        System.out.println("所在月的第一天"+localDate.with(TemporalAdjusters.lastDayOfMonth()));

        //300年/月后的日期
        System.out.println("[300年后的日期]"+localDate.plusYears(300));
        System.out.println("[300月后的日期]"+localDate.plusMonths(300));
        System.out.println("[300天后的日期]"+localDate.plusDays(300));

        System.out.println("所处月的第一个周一"+localDate.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)));
        System.out.println("所处年的第一个周一"+LocalDate.parse("1988-01-15").with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)));

    }
}

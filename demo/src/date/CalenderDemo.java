package date;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @Author 王江超
 * @Date 2019/12/27 13:53
 * @Description:
 */
public class CalenderDemo {

    public static void main(String[] args) {
        //获取代表当前系统 的Calendar类
        Calendar calendar = Calendar.getInstance();

        int year = calendar.get(Calendar.YEAR);




        GregorianCalendar gcalendar = new GregorianCalendar();
        //判断是否为闰年
        gcalendar.isLeapYear(year);



    }
}

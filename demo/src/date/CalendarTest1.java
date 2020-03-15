package date;

import java.util.Calendar;

public class CalendarTest1 {

    public static void main(String[] args) {

        //获取Calendar实例对象
        Calendar calendar = Calendar.getInstance();
        //计算多少年之后的时间
        calendar.add(Calendar.YEAR,10);

        //计算6个月之后的日期
        calendar.add(Calendar.MONTH,6);
        System.out.println(String.format("当前的日期格式:%s-%s-%s %s-%s-%s",calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH)+1,
                calendar.get(Calendar.DAY_OF_MONTH),
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                calendar.get(Calendar.SECOND)));


    }


}

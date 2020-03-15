package date;

import java.util.Calendar;

public class CalendarTest2 {

    public static void main(String[] args) {

        //获取Calendar实例对象
        Calendar calendar = Calendar.getInstance();

        //8月的最后一天
        calendar.set(calendar.get(Calendar.YEAR),8,1);  //通过9月 计算8月的最后一天
        calendar.add(Calendar.DATE,-1);


        System.out.println(String.format("当前的日期格式:%s-%s-%s %s:%s:%s",calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH)+1,
                calendar.get(Calendar.DAY_OF_MONTH),
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                calendar.get(Calendar.SECOND)));
    }


}

package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author 王江超
 * @Date 2020/3/12 18:05
 * @Description:
 */
public class DateTest3 {

    public static void main(String[] args) {

        /**
         * 将String类型转为 Date类型
         */
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = "2020-03-13 06:32:44";
        String time2 = "2020-05-13 06:32:44";
        Date date1 = null;
        Date date3 = null;
        try {
             date1 =sdf.parse(time);
             date3 = sdf.parse(time2);
            System.out.println(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        /**
         * 比较两个时间
         */
        System.out.println("时间比较"+date3.after(date1));
        System.out.println("时间比较"+date3.before(date1));


        //获取long型的时间戳
        System.out.println(date1.getTime());
        Long date2 =  date1.getTime()-1000;
        //将Long型转为String类型的时间
        //通过构造方法 接受Long类型的时间戳
        String format = sdf.format(new Date(date2));
        System.out.println(format);





    }
}

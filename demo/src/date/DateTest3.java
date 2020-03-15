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

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = "2020-03-13 06:32:44";
        Date date = null;
        try {
             date =sdf.parse(time);
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println(date.getTime());
        Long date1 =  date.getTime()-1000;

        String format = sdf.format(new Date(date1));
        System.out.println(format);

    }
}

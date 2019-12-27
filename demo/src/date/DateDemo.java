package date;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author 王江超
 * @Date 2019/12/27 11:24
 * @Description:
 */
public class DateDemo {

    public static void main(String[] args) {

        Date date = new Date();
        System.out.println("当前时间"+date);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String format = sdf.format(date);

        boolean after = date.after(format);
        System.out.println(after);



    }





}

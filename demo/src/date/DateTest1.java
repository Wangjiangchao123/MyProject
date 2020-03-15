package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author 王江超
 * @Date 2020/3/11 17:34
 * @Description:
 */
public class DateTest1 {

    public static void main(String[] args) {
        /**
         * 时间戳转换为时间 （String）
         */
        Long timeStamp = System.currentTimeMillis();  //获取当前时间戳
        System.out.println(timeStamp);

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sd = sdf.format(new Date(Long.parseLong(String.valueOf(timeStamp))));      // 时间戳转换成时间
        System.out.println("格式化结果：" + sd);

//        Date date = new Date();
//        long time = date.getTime()-1000;
//        Date date1 = new Date(Long.parseLong(String.valueOf(time)));


//        SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time="2020-03-11 17:41:09";
        Date date = null;
        try {
            date = sdf.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.print("格式化结果:"+date.getTime());



    }
}

package regular;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author 王江超
 * @Date 2019/12/27 14:45
 * @Description:  正则
 */
public class RegularDemo {

    public static void main(String[] args) {

        String str= "select  ?Prem?/1000*rate*chgpaymode248(?PayIntv?)*?FRate?  from rated020 where  AppAge=?AppAge? and sex='?sex?' and trim(PayIntv)=trim(chgPayIntv248(?PayIntv?) ) and payendyear='?payendyear?' and payendyearflag='?payendyearflag?'";

        String pattern = "\\?[a-zA-Z]+\\?";

        String b = null;
        Pattern r = Pattern.compile(pattern);
        List<String> list = new ArrayList<>();
        Matcher m = r.matcher(str);
//        System.out.println(m.matches());
//        System.out.println(m.find());
//        System.out.println(m.lookingAt());
//        System.out.println(m.toString());
        while(m.find()){

            list.add(m.group());
        }

        System.out.println(list);

        for (int i=0;i<list.size();i++){
          String a =   list.get(i).replace("?","");
            System.out.println(a);
            //忽略大小写
            a.equalsIgnoreCase(b);
        }

    }
}

package contain;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 王江超
 * @Date 2019/12/23 17:16
 * @Description:
 */
public class ContainMain {


    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        List<String> list1 = new ArrayList<>();
        list1.add("2");
        list1.add("4");
        list1.add("6");
        list1.add("7");

        boolean b = list1.containsAll(list);
        System.out.println(b);
    }
}

package list;

import java.util.*;

/**
 * @Author 王江超
 * @Date 2019/12/25 13:58
 * @Description:
 */
public class ListDemo {


    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.add("cc");
        System.out.println(list);

        List<String> list1 = new LinkedList<>();
        list1.add("aa");
        list1.add("bb");
        list1.add("cc");
        list1.add("cc");
        System.out.println(list1);


        Set<String>  set = new HashSet<>();
        set.add("aa");
        set.add("bb");
        set.add("cc");
        set.add("cc");
        System.out.println(set);




    }
}

package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author 王江超
 * @Date 2019/12/27 11:07
 * @Description:
 */
public class ArrayDemo {

    public static void main(String[] args) {

        int [] nums = {1,1,12,34,85};

        int [] num1 = new int[3];

        int [] num2 = new int[]{2,3,5,8};

        int [] num3 = new int[]{};

        System.out.println(num3.length);
        List<int[]> list = Arrays.asList(num2);
        System.out.println(list);
        List list1 = new ArrayList();
        Object[] objects = list1.toArray();


    }




}

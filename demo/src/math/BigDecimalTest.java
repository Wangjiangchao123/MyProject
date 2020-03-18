package math;

import java.math.BigDecimal;

public class BigDecimalTest {

   static   BigDecimal c1 = new BigDecimal(0);
   static   BigDecimal c2 = new BigDecimal(1);

    public static void main(String[] args) {
//        test(new BigDecimal(0.222));
        add(new BigDecimal(3.00),new BigDecimal(2.00));
    }


    /**
     *  等于0    a=c1
     *  等于1    a>c1
     *  等于-1   a<c1
     *
     *
     *
     * @param a
     */
    public  static void  test(BigDecimal a){
        if (a.compareTo(c1) == -1){
            System.out.println("a <c1");
        }
        if (a.compareTo(c1) == 0 ){
            System.out.println("a=c1");
        }
        if (a.compareTo(c1)==1){
            System.out.println("a>c1");
        }

        if (a.compareTo(c2) == -1 ){
            System.out.println( "a < c2");
        }
        if (a.compareTo(c2) == 1 ){
            System.out.println( "a > c2");
        }
        if (a.compareTo(c2) == 0 ){
            System.out.println( "a = c2");
        }

        if (a.compareTo(c1) == 1 && a.compareTo(c2) ==-1){
            System.out.println(" 0 < a < 1");
        }
    }


    public static BigDecimal add(BigDecimal a,BigDecimal b){
        BigDecimal add = a.add(b);
        System.out.println("bigdecimal加法"+add);
        BigDecimal divide = a.divide(b);
        System.out.println(divide);
        BigDecimal multiply = a.multiply(b);
        System.out.println(multiply);
        BigDecimal subtract = a.subtract(b);
        System.out.println(subtract);
        BigDecimal max = a.max(b);
        System.out.println("最大值"+max);
        return add;
    }
}

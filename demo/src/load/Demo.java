package load;


public class Demo {

    static {
        System.out.println("Test的静态代码块");
    }


    public static void main(String[] args) {
        System.out.println("执行main方法");
        ClassB b = new ClassB();
//        b.excute();
    }

}
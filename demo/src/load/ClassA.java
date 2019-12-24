package load;

public class ClassA {

    public static  ClassA classa = new ClassA();

    static{
        System.out.println("ClassA的静态代码块------3");
    }

    public ClassA(){
        System.out.println("ClassA的构造方法-------2");
    }

    {
        System.out.println("ClassA的构造代码块------1");
    }

}
package load;

public class ClassB extends ClassA{

    static{
        System.out.println("ClassB的静态代码块 B------B1");
    }

    public ClassB(){

        System.out.println("ClassB的构造方法-----5");
    }

    {
        System.out.println("ClassB的构造代码块------");
    }

    public static  ClassC classc = new ClassC();

    public void excute(){
        System.out.println("执行方法");
    }

}

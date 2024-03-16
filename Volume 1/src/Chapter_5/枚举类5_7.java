package Chapter_5;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/3/16 20:52
 * @description 5.7 枚举类 Core Java第一卷P201-203
 **/
public class 枚举类5_7 {
    public static void main(String[] args) {
        //枚举类
        //枚举类是一种特殊的类,它表示一组常量
        //枚举类的定义是使用关键字enum
        //补充内容在同包下的Size.java文件中查看
        //枚举类继承了java.lang.Enum类,并且不能再继承其他类
        //它继承了许多方法,其中最有用的是toString方法
        //toString方法返回枚举常量的名字
        System.out.println(Size.SMALL.toString());

        //toString的逆方法是静态方法valueOf
        //valueOf方法返回一个枚举常量,它的名字与给定字符串相同
        //这个方法是由编译器生成的,不需要程序员自己编写
        Size size = Enum.valueOf(Size.class, "SMALL");
        System.out.println(size);

        //每个枚举类都有一个静态的values方法,返回一个包含全部枚举值的数组
        Size[] values = Size.values();
        for (Size value : values) {
            System.out.print(value + " ");
        }
        System.out.println();

        //ordinal方法返回枚举常量的序数,从0开始

        int ordinal = Size.EXTRA_LARGE.ordinal();
        System.out.println("EXTRA_LARGE的序数是: " + ordinal);


    }
}


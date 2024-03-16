package Chapter_4.src;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/3/15 18:39
 * @description 4.3.5 用var声明局部变量 Core Java第一卷P109
 **/
public class 用var声明局部变量4_3_5 {
    //Java 10引入了这种var声明局部变量
    public static void main(String[] args) {
        //var声明局部变量
        //如果从变量初始值可以推导出他们的类型,那么可以用var关键字声明局部变量,而无需指定类型
        var message = "Hello, World!";
        var number = 100;
        System.out.println(message);
        System.out.println(number);
    }
}

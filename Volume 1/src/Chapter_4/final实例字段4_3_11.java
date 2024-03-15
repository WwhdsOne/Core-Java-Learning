package Chapter_4;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/3/15 18:49
 * @description 4.3.11 final实例字段 Core Java第一卷P114
 **/
public class final实例字段4_3_11 {
    public static void main(String[] args) {
        Employee employee = new Employee("Wwh",100);
        System.out.println(employee.builder);//输出Hello, Wwh!
        employee.builder.append("Hello, World AGAIN!");
        System.out.println(employee.builder);//输出Hello, Wwh!Hello, World AGAIN!
    }
}
class Employee{
    //可以将实例字段定义为final,这样字段必须在构造对象时初始化
    private final String name;
    private double salary;
    //final修饰符对于基本类型的字段,意味着字段的值一旦设置,就不能再更改
    //对于对象引用,final意味着引用不能更改,但是对象本身可以更改
    public final StringBuilder builder = new StringBuilder();
    public Employee(String name, double salary){
        this.name = name;
        this.salary = salary;
        builder.append("Hello, %s!".formatted(name));
    }
}

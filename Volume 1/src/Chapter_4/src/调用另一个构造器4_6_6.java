package Chapter_4.src;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/3/16 17:00
 * @description 4.6.6 调用另一个构造器 Core Java第一卷P29
 **/
public class 调用另一个构造器4_6_6 {
    public static void main(String[] args) {
        var e = new Employee_Three("Wwh", 100);
        System.out.println(e.getId());
        var e1 = new Employee_Three(100);
        System.out.println(e1.getId());
        var e2 = new Employee_Three();
        System.out.println(e2.getId());

    }
}
class Employee_Three{
private String name;
    private double salary;
    public Employee_Three(String name, double salary){
        this.name = name;
        this.salary = salary;
    }
    public Employee_Three(double salary){
        //调用另一个构造器
        this("Employee #"+nextId, salary);
    }
    public Employee_Three(){
        //调用另一个构造器
        this("Employee #"+nextId, 0);
    }
    //静态字段
    private static int nextId;
    //静态初始化块
    static {
        var generator = new java.util.Random();
        //设置一个0-9999之间的随机数
        nextId = 1000;
    }
    //实例初始化块
    {
        id = nextId;
        nextId++;
    }
    private int id;
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public double getSalary(){
        return salary;
    }
}

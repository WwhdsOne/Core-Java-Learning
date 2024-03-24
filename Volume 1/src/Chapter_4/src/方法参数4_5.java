package Chapter_4.src;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/3/16 16:28
 * @description 4.5 方法参数 Core Java第一卷P120-125
 **/
public class 方法参数4_5 {
    public static void main(String[] args) {
        /**
         * Test1: 方法不能修改基本数据类型的参数
         */
        System.out.println("Test1: 方法不能修改基本数据类型的参数");
        double percent = 10;
        System.out.println("Before: percent = " + percent);
        tripleValue(percent);
        System.out.println("End of method: percent = " + percent);
        //调用方法后,percent的值没有改变
        //下面来看发生了什么
        //1.在调用方法时,参数的值被复制,并传递给方法
        //2.在方法中,参数的值被修改,但是原始变量的值没有改变

        /**
         * Test2: 方法可以改变对象参数的状态
         */
        System.out.println("Test2: 方法可以改变对象参数的状态");
        var harry = new Employee_Two("Harry", 50000);
        System.out.println("Before: salary = " + harry.getSalary());
        tripleSalary(harry);
        System.out.println("End of method: salary = " + harry.getSalary());
        //调用方法后,harry的工资被改变
        //下面来看发生了什么
        //1.x初始化为harry值的一个副本,它指向一个Employee_Two对象
        //2.在方法中,参数x指向的对象的工资被修改,x和harry同时引用的那个对象的工资被修改
        //3.方法结束后,参数x被销毁,但是harry仍然指向那个对象

        /**
         * Test3: 方法不能让对象参数引用一个新的对象
         */
        System.out.println("Test3: 方法不能让对象参数引用一个新的对象");
        var a = new Employee_Two("Alice", 70000);
        var b = new Employee_Two("Bob", 60000);
        System.out.println("Before: a = " + a.getName());
        System.out.println("Before: b = " + b.getName());
        swap(a, b);
        System.out.println("End of method: a = " + a.getName());
        System.out.println("End of method: b = " + b.getName());
        //调用方法后,a和b的值没有改变
        //下面来看发生了什么
        //1.在方法中,参数x和y初始化为a和b的值的副本
        //2.在方法中,参数x和y分别指向一个Employee_Two对象
        //3.在方法中,参数x和y被销毁,但是a和b仍然指向原来的对象
        //这说明:Java程序设计语言对对象采用的不是按引用调用,而是按值调用

        //下面总结在Java中,方法参数能做什么和不能做什么
        //1.方法不能修改基本数据类型的参数
        //2.方法可以改变对象参数的状态
        //3.方法不能让对象参数引用一个新的对象


    }
    //将传入参数"翻3倍"
    public static void tripleValue(double x){
        x = 3 * x;
        System.out.println("End of method: x = " + x);
    }
    //将传入参数的工资翻3倍
    public static void tripleSalary(Employee_Two x){
        x.raiseSalary(200);
        System.out.println("End of method: salary = " + x.getSalary());
    }
    public static void swap(Employee_Two x, Employee_Two y){
        Employee_Two temp = x;
        x = y;
        y = temp;
    }
}
class Employee_Two {
    private String name;
    private double salary;

    public Employee_Two(String n, double s) {
        name = n;
        salary = s;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }
}

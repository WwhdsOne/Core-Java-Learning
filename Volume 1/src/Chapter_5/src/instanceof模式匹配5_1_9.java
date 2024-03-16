package Chapter_5.src;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/3/16 19:32
 * @description 5.1.9 instanceof模式匹配 Core Java第一卷P172-173
 **/
public class instanceof模式匹配5_1_9 {
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.name = "Wwh";
        employee.salary = 100.0;
        if(employee instanceof Manager){
            Manager boss = (Manager) employee;
            boss.bonus = 1000;
        }
        //Manager在这三行中出现了三次,实在是太麻烦了,所以引入了模式匹配
        if(employee instanceof Manager boss){
            boss.bonus = 1000;
        }

    }
}
class Manager extends Employee{
    public double bonus;

}


class Employee{


    public String name;
    public double salary;
}

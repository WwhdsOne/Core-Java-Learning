package Chapter_5.src.反射5_9;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/3/22 15:14
 * @description 公用Employee类
 **/
class Employee {
    public String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
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

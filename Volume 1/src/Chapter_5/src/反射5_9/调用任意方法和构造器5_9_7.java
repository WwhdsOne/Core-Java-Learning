package Chapter_5.src.反射5_9;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/3/22 15:39
 * @description 5.9 反射 Core Java第一卷P227-230
 **/
public class 调用任意方法和构造器5_9_7 {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        // 创建一个 Employee 对象，名字为 "Harry Hacker"，薪水为 50000
        Employee harry = new Employee("Harry Hacker", 50000);

        // 打印出 Harry 的薪水
        System.out.println(harry.getSalary());

        // 获取 Employee 类的 Class 对象
        Class c1 = Employee.class;

        // 获取 Employee 类的 "raiseSalary" 方法，该方法接受一个 double 类型的参数
        Method m1 = c1.getMethod("raiseSalary", double.class);

        // 使用反射调用 harry 的 "raiseSalary" 方法，参数为 100
        // 这相当于执行了 harry.raiseSalary(100)
        m1.invoke(harry, 100);

        // 打印出调用 "raiseSalary" 方法后 Harry 的薪水
        System.out.println(harry.getSalary());

        // 获取 Employee 类的 "getName" 方法，该方法没有参数
        Method m2 = c1.getMethod("getName");

        // 使用反射调用 harry 的 "getName" 方法
        // 这相当于执行了 harry.getName()
        // 因为 "getName" 方法返回一个 String，所以我们需要将结果转换为 String
        var name = (String) m2.invoke(harry);

        // 打印出 Harry 的名字
        System.out.println(name);
    }
}

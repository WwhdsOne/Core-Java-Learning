package Chapter_5.src.反射5_9;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/3/22 15:09
 * @description 5.9 反射 Core Java第一卷P224-227
 **/
public class 使用反射类编写泛型数组代码5_9_6 {
    public static void main(String[] args) {
        //Arrays类的静态方法copyOf可以用来扩展数组
        //但是，如果我们想要创建一个泛型数组，就不能使用copyOf方法
        //我们可以使用反射类Array的newInstance方法来创建一个泛型数组
        var employees = new Employee[2];
        employees[0] = new Employee("Harry Hacker", 50000);
        employees[1] = new Employee("Tony Tester", 40000);
        //不过这个方法返回的是一个Object数组,但是由于创建的是Objects数组,所以不能将其转换为Employee数组
        //Object[] objects = badCopyOf(employees, 3);
        //这里会抛出ClassCastException异常
        //Employee[] employees1 = (Employee[]) objects;
        //我们可以使用Arrays.newInstance方法来创建一个泛型数组
        //这个方法的第一个参数是数组的元素类型，第二个参数是数组的长度
        employees = (Employee[]) goodCopyOf(employees, 3);
        employees[2] = new Employee("Wwhds Boss", 2333333);
        for ( Employee employee : employees ) {
            System.out.println("Name = " + employee.getName() + " Salary = " + employee.getSalary());
        }
    }

    public static Object[] badCopyOf(Object[] a, int newLength) {
        //创建一个新数组
        var newArray = new Object[newLength];
        //将原数组的元素复制到新数组中
        System.arraycopy(a, 0, newArray, 0, Math.min(a.length, newLength));
        return newArray;
    }

    public static Object goodCopyOf(Object a, int newLength) {
        Class cl = a.getClass();
        if ( !cl.isArray() ) {
            return null;
        }
        //获取数组的元素类型
        Class componentType = cl.getComponentType();
        int length = Array.getLength(a);
        Object newArray = Array.newInstance(componentType, newLength);
        System.arraycopy(a, 0, newArray, 0, Math.min(length, newLength));
        return newArray;
    }


}



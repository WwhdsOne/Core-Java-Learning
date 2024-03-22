package Chapter_5.src.反射5_9;

import java.lang.reflect.Field;
import java.util.StringJoiner;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/3/21 14:46
 * @description 5.9 反射 Core Java第一卷P220-224
 **/
public class 使用反射在运行时分析对象5_9_5 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        //在运行时分析对象
        Employee harry = new Employee("Harry Hacker", 50000);
        Class cl = Employee.class;

        //首先获取对应字段
        Field field = cl.getDeclaredField("name");
        //然后获取字段的值
        Object obj = field.get(harry);
        System.out.println(obj);

        //相应地也可以设置字段的值
        field.set(harry, "HaHa Hacker");
        obj = field.get(harry);
        System.out.println(obj);

        //对于私有字段我们同样可以获取
        //首先覆盖Java的访问控制
        Field s = cl.getDeclaredField("salary");
        s.setAccessible(true);
        s.set(harry, 100000);
        obj = s.get(harry);
        System.out.println(obj);
        //setAccessible方法是AccessibleObject类的一个方法，它是Field、Method和Constructor类的超类
        //这个特性是为调试和测试而设计的，不应该在生产代码中使用

        //通过setAccessible方法，我们可以编写一个通用的toString方法，它可以打印出任何对象的所有字段
        //可以查看下方的toString方法
        toString(harry);


    }

    public static void toString(Object obj) throws IllegalAccessException {
        Class cl = obj.getClass();
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        Field[] declaredFields = cl.getDeclaredFields();
        for ( Field declaredField : declaredFields ) {
            declaredField.setAccessible(true);
            joiner.add(declaredField.getName() + "=" + declaredField.get(obj));
        }
        System.out.println(joiner);
    }
}


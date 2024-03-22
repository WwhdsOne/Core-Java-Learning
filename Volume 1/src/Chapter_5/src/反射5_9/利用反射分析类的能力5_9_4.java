package Chapter_5.src.反射5_9;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/3/21 14:20
 * @description 5.9 反射 Core Java第一卷P213-220
 **/
public class 利用反射分析类的能力5_9_4 {
    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException {
        //java.lang.reflect包中有三个类Field、Method和Constructor
        //这三个类分别表示类的字段、方法和构造器
        Double d = 3.14;
        //这三个类都有getName方法,返回字段、方法和构造器的名字
        Class cl = d.getClass();

        Field field = cl.getDeclaredField("value");
        Method method = cl.getMethod("toString");
        Constructor constructor = cl.getConstructor(double.class);
        System.out.println(field.getName());
        System.out.println(method.getName());
        System.out.println(constructor.getName());

        //Field类有一个getType方法,返回字段的类型,返回一个Class对象
        System.out.println(field.getType().getName());

        //Method类有一个getReturnType方法,返回方法的返回类型,返回一个Class对象
        System.out.println(method.getReturnType().getName());

        //这三个类都有一个getModifiers方法,返回一个整数,表示字段、方法和构造器的修饰符
        System.out.println(field.getModifiers());
        System.out.println(method.getModifiers());
        System.out.println(constructor.getModifiers());

        //利用Modifier类的静态方法可以查看字段属性
        System.out.println(Modifier.isPrivate(field.getModifiers()));
        System.out.println(Modifier.isPublic(field.getModifiers()));
        System.out.println(Modifier.isProtected(field.getModifiers()));

    }
}

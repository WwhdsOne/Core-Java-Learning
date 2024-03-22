package Chapter_5.src.反射5_9;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/3/21 13:59
 * @description 5.9 反射 Core Java第一卷P209-211
 **/
public class 反射5_9_1 {
    public static void main(String[] args) throws ClassNotFoundException {
        //在程序运行期间，Java运行时系统始终为所有对象维护一个表示对象的Class对象
        //Class对象包含了与对象有关的信息
        //Class对象是在类加载时由Java虚拟机创建的
        // 方法1：使用.getClass()方法
        String str = "Hello, World!";
        Class<?> class1 = str.getClass();
        System.out.println(class1.getName());

        // 方法2：使用.class语法
        Class<?> class2 = String.class;
        System.out.println(class2.getName());

        // 方法3：使用Class.forName()方法
        Class<?> class3 = Class.forName("java.lang.String");
        System.out.println(class3.getName());

        //可以使用 == 运算符比较两个类的对象
        System.out.println(class1 == class2);

    }
}

class Animal{
    private String name;
    private int age;
    public Animal(String name,int age){
        this.name = name;
        this.age = age;
    }
    public void eat(){
        System.out.println("Animal eat");
    }
    public void sleep(){
        System.out.println("Animal sleep");
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }
}

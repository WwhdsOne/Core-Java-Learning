package Chapter_6.src;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/3/22 16:29
 * @description 6.1 对象克隆 Core Java第一卷P247-252
 **/
public class 对象克隆6_1_9 {
    public static void main(String[] args) throws CloneNotSupportedException {
        //在Java中，对象克隆是一种特殊的对象创建方式，它不通过构造器来创建对象，而是通过克隆一个现有对象来创建新对象
        Student s1 = new Student("Wwh", 20);
        Student s2 = s1;
        System.out.println(s1.getName());

        s1.setName("Wwhds");
        System.out.println(s1.getName());
        System.out.println(s2.getName());
        //可以看到，s1和s2指向的是同一个对象，所以s1的name改变了，s2的name也会改变

        //我们可以使用Object类的clone方法来实现对象的克隆,它属于默认的拷贝方式
        //但是这种方式是浅拷贝，即只拷贝对象的引用，而不拷贝对象的内容
        //所以如果对象中有引用类型的成员变量，那么这种方式就不适用
        //所以若是想要实现深拷贝，就需要重写clone方法
        var s3 = (Student)s1.clone();
        s1.setName("Wwh");
        s3.setName("Wwhdsds");
        System.out.println(s3.getName());

        //要当心子类的克隆
        //一旦为父类实现了clone方法，子类也会继承这个方法，但是这个方法是浅拷贝






    }
}

class Student implements Cloneable{
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String string) {
        name = string;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

package Chapter_2.保存和加载序列化对象;

import java.io.*;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/4/15 下午4:34
 * @description 保存和加载序列化对象
 **/
public class 保存和加载序列化对象 {

    private static String path = "D:\\Programming_Learning\\Project\\Core Java\\Volume 2\\src\\Chapter_4\\保存和加载序列化对象\\对象保存.txt";
    public static void main(String[] args) {
        try {
            保存序列化对象();
            加载序列化对象();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void 加载序列化对象() throws IOException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path));
        try {
            while (true) {
                Student student = (Student) objectInputStream.readObject();
                System.out.println(student.getName() + " " + student.getAge());
            }
        } catch (EOFException e) {
            System.out.println("加载完毕");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void 保存序列化对象() throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
        Student student1 = new Student("Wwh", 20);
        Student student2 = new Student("LOL", 21);
        objectOutputStream.writeObject(student1);
        objectOutputStream.writeObject(student2);
    }
}

class Student implements Serializable {
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
}


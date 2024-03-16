package Chapter_5;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/3/16 19:21
 * @description 5.1.8 强制类型转换 Core Java第一卷P170-172
 **/
public class 强制类型转换5_1_8 {
    public static void main(String[] args) {
        //强制类型转换
        //强制类型转换是将一个数值从一种数值类型转换为另一种数值类型
        //强制类型转换是通过在括号中放置目标类型来完成的
        //强制类型转换可能会导致精度丢失
        //强制类型转换可能会导致溢出
        int n = (int) 123.456;
        System.out.println(n);
        Animal animal = new Animal();
        Dog dog = new Dog();
        dog.name = "good dog";
        dog.eat();
        dog.bark();

        //在类型转换之前,可以使用instanceof检查对象的类型
        //instanceof运算符检查对象是否是某个特定类的实例
        //instanceof运算符的结果是一个布尔值
        //instanceof运算符的语法是对象 instanceof 类名
        //如果对象是指定类的实例,那么结果为true,否则为false
        if(animal instanceof Animal){ //animal是Animal的实例
            System.out.println("animal is an animal");
        }
        if(animal instanceof Dog){ //animal不是Dog的实例
            System.out.println("animal is a dog");
        }
        if(dog instanceof Animal){ //dog是Animal的实例
            System.out.println("dog is an animal");
        }

        if(dog instanceof Dog){ //dog是Dog的实例
            System.out.println("dog is a dog");
        }

        if(null instanceof Dog){ //null不是Dog的实例
            System.out.println("null is a dog");
        }
    }
}

class Dog extends Animal{
    public void bark(){
        System.out.println("barking");
    }
}

class  Animal{
    public String name;
    public void eat(){
        System.out.printf("%s eating\n",name);
    }
}

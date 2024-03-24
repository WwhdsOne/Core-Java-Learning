package Chapter_6.src.lambda表达式;

import java.sql.Time;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/3/23 11:24
 * @description 方法引用 Core Java第一卷P258-260
 **/
public class 方法引用6_2_4 {
    public static void main(String[] args) {
        // 方法引用是一种更简洁的lambda表达式
        // 方法引用是lambda表达式的一种简写形式
        // 方法引用是用来直接访问类或者实例的已经存在的方法或者构造方法
        // 方法引用提供了一种引用而不执行方法的方式
        // 方法引用的操作符是::
        var s = new Integer[10];
        Random random = new Random();
        for (int i = 0; i < s.length; i++) {
            s[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(s));
        // 使用lambda表达式实现Comparator接口对数组进行排序
        // Arrays.sort(s, (o1, o2) -> o1 - o2);
        // 使用方法引用实现Comparator接口对数组进行排序
        Arrays.sort(s, Integer::compare);
        System.out.println(Arrays.toString(s));

        // 要用::操作符分隔方法名和对象或类名,主要有三种情况
        // 1. object::instanceMethod
        String str = "    Wwhds      ";
        Supplier<String> supplier = str::trim;
        String trimmedStr = supplier.get();
        System.out.println(trimmedStr);  // 输出："Wwhds"
        // 2. Class::staticMethod
        //iFunction 是Java中的一个函数式接口，它代表了一个接受两个输入参数并产生一个结果的函数。
        //这是一个泛型接口，可以操作任何类型的对象。
        BiFunction<Double, Double, Double> power = Math::pow;
        double result = power.apply(2.0, 3.0);
        System.out.println(result);  // 输出：8.0
        // 3. Class::instanceMethod
        // 使用 String::length 方法引用创建 Function 实例
        Function<String, Integer> function = String::length;

        // 使用 Function 实例获取字符串的长度
        int length = function.apply("Hello, world!");
        System.out.println(length);  // 输出：13
        //第三种方法的第一个参数会成为方法的隐式参数
        //第二种情况下，所有参数都传递到静态方法Math::pow等价于(x,y)->Math.pow(x,y)

        //方法引用中也可以使用this和super关键字
        //this::equals等价于x->this.equals(x)

    }
}

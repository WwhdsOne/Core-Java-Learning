package Chapter_6.src.lambda表达式;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/3/22 17:15
 * @description 6.2.3 函数式接口 Core Java第一卷P256-257
 **/
public class 函数式接口6_2_3 {
    public static void main(String[] args) {
        // 函数式接口是只有一个抽象方法的接口
        // 通过lambda表达式来实现函数式接口
        var s = new Integer[10];
        Random random = new Random();
        for (int i = 0; i < s.length; i++) {
            s[i] = random.nextInt(100);
        }
        // 使用lambda表达式实现Comparator接口对数组进行排序
        Arrays.sort(s, Comparator.comparingInt(integer -> integer));


    }
}

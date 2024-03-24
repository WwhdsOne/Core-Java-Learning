package Chapter_6.src.lambda表达式;

import java.util.Arrays;
import java.util.Comparator;

import static java.util.Comparator.nullsFirst;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/3/22 17:01
 * @description 6.2.1 lambda表达式 Core Java第一卷P254-256
 **/
public class lambda表达式的语法6_2_2 {

    public static void main(String[] args) {
        String s1 = "Wwh";
        String s2 = "hwW";
        // 使用lambda表达式实现字符串长度的比较
        // Comparator<String> lengthComparator = (String str1,String str2) -> str1.length() - str2.length();
        // 如果可以推导出表达式的参数类型，就可以省略参数类型
        Comparator<String> lengthComparator = (str1, str2) -> str1.length() - str2.length();

        // 使用比较器进行比较
        int result = lengthComparator.compare(s1, s2);

        // 打印结果
        if (result < 0) {
            System.out.println(s1 + " is shorter than " + s2);
        } else if (result > 0) {
            System.out.println(s1 + " is longer than " + s2);
        } else {
            System.out.println(s1 + " and " + s2 + " have the same length");
        }
    }
}

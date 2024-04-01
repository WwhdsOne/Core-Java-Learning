package Chapter_7;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/3/26 19:35
 * @description 递归斐波那契数列栈轨迹
 **/
public class 递归斐波那契数列栈轨迹 {
    public static void main(String[] args) {
        try(var in = new Scanner(System.in)) {
            System.out.println("Enter n: ");
            int n = in.nextInt();
            int f = fibonacci(n);
            System.out.println("fibonacci(" + n + ") = " + f);
        }
    }

    public static int fibonacci(int n) {
        System.out.println("factorial(" + n + "):");
        var walker = StackWalker.getInstance();
        walker.forEach(System.out::println);
        int r;
        if (n <= 2) {
            r = 1;
        } else {
            r = fibonacci(n - 1) + fibonacci(n - 2);
            System.out.println("return " + r);
        }
        return r;
    }
}

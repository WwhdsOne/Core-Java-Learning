package Chapter_7;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Stack;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/3/26 19:46
 * @description 异常使用的技巧
 **/
public class 异常使用的技巧 {
    public static void main(String[] args) {
        LocalDateTime start = LocalDateTime.now();
        TryPopWithException();
        LocalDateTime end = LocalDateTime.now();
        System.out.println("TryPopWithOutException: " + ChronoUnit.MILLIS.between(start, end));
    }

    //查看栈是否为空
    public static void TryPopWithOutException() {
        Stack<Integer> stack = new Stack<>();
        for ( int i = 0; i < 10000000; i++ ) {
            if(!stack.isEmpty()) {
                stack.pop();
            }
        }
    }
    //捕获异常
    public static void TryPopWithException() {
        Stack<Integer> stack = new Stack<>();
        for ( int i = 0; i < 10000000; i++ ) {
            try{
                stack.pop();
            } catch (Exception e) {
                // do nothing
            }
        }
    }
}

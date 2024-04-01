package Chapter_12;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/3/31 18:01
 * @description
 **/
public class 线程基本例子 {
    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("Hello, World! Two!");
            }
        }).start();
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println("Hello, World! One!");
            }
        }).start();
    }
}

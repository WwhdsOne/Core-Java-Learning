package Chapter_12;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/4/2 16:20
 * @description 线程局部变量
 **/
public class 线程局部变量 {

    public static final ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);


    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            threadLocal.set(233);
            System.out.println(Thread.currentThread().getName() + "的threadLocal值为：" + threadLocal.get());
        });

        Thread t2 = new Thread(() -> {
            threadLocal.set(666);
            System.out.println(Thread.currentThread().getName() + "的threadLocal值为：" + threadLocal.get());
        });
        t1.start();
        t2.start();

    }
}

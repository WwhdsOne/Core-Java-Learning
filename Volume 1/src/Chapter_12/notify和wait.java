package Chapter_12;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/4/7 下午3:39
 * @description notify和wait
 **/
public class notify和wait {
    private static final Object lock = new Object();
    private static boolean flag = false;

    public static void main(String[] args) {

    }

    public synchronized void test() throws InterruptedException {
        wait();
    }
}

package Chapter_12.实践;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/5/15 下午6:36
 * @description 线程状态切换
 **/
public class 线程状态切换 extends Thread{

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }
}

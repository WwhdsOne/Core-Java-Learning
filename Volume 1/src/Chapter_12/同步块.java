package Chapter_12;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/4/1 20:16
 * @description 同步块
 **/
public class 同步块 {

    private static Object lock = new Object();

    private static int sharedVariable = 0;
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for ( int i = 0; i < 100000; i++ ) {
                plus();
            }
        });

        Thread thread2 = new Thread(() -> {
            for ( int i = 0; i < 100000; i++ ) {
                plus();
            }
        });
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final value of shared variable: " + sharedVariable);

    }

    public static void plus(){
        synchronized (lock){
            sharedVariable++;
        }
    }
    private static synchronized void plus1(){
        sharedVariable++;
    }
}

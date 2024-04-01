package Chapter_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/4/1 16:45
 * @description 竞态条件的一个例子
 **/
public class 竞态条件的一个例子 {
    private static int sharedVariable = 0;

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for ( int i = 0; i < 1000; i++ ) {
                sharedVariable++;
            }
        });

        Thread thread2 = new Thread(() -> {
            for ( int i = 0; i < 1000; i++ ) {
                sharedVariable--;
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
}

package Chapter_12;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/4/2 11:59
 * @description volatile字段
 **/
public class volatie字段 {

    private static int sum = 0;

    public static void main(String[] args) throws InterruptedException {
        Runnable r = () -> {
            for(int i = 0;i<1000000;i++){
                plus();
            }
        };
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
        Thread.sleep(5000);
        System.out.println(sum);
    }

    private static synchronized void plus(){
        sum++;
    }


}

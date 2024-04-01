package Chapter_12;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/4/1 12:39
 * @description 中断线程
 **/
public class 中断线程 {
    public static void main(String[] args) throws InterruptedException {
        Runnable r = () ->{
            try {
                sleep方法和中断状态();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        Thread t = new Thread(r);
        t.start();
    }

    public static void 检查中断状态() {
        Runnable r = () -> {
            int i = 233;
            for ( int j = 0; j < i; j++ ) {
                System.out.println("当前是第" + j + "次循环");
                if ( j == 10 ) {
                    Thread.currentThread().interrupt();
                }
                if ( Thread.currentThread().isInterrupted() ) {
                    System.out.println("线程被中断");
                    break;
                }
            }
        };
        Thread t = new Thread(r);
        t.start();
    }

    public static void sleep方法和中断状态() throws InterruptedException {
        int i = 233;
        for ( int j = 0; j < i; j++ ) {
            System.out.println("当前是第" + j + "次循环");
            if ( j == 10 ) {
                Thread.currentThread().interrupt();
            }
            Thread.sleep(300);
        }
    }

}

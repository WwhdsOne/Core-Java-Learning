package Chapter_12;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/4/1 16:28
 * @description 未捕获异常的处理器
 **/
public class 未捕获异常的处理器 {
    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new 处理器());
        int i = 1/0;
    }
}

class 处理器 implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("线程" + t.getName() + "抛出了异常");
        e.printStackTrace();
    }
}

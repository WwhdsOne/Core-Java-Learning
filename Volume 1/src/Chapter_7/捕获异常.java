package Chapter_7;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/3/25 20:49
 * @description 捕获异常
 **/
public class 捕获异常 {
    public static void main(String[] args) {
        try {
            throw new Exception("抛出异常");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package Chapter_7;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/3/25 20:27
 * @description 创建异常类
 **/
public class 创建异常类 {
    public static void main(String[] args) throws Exception {
        class WwhException extends Exception {
            public WwhException(String message) {
                super(message);
            }
        }
        var exception = new WwhException("自定义异常");
        throw exception;
    }
}

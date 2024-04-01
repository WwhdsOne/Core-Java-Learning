package Chapter_7;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/3/29 23:11
 * @description 断言
 **/
public class 断言 {
    public static void main(String[] args) {
        int x = 1;
        assert x > 0;
        System.out.println(x);
        assert x < 0 : "x = " + x;
    }
}

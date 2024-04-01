package Chapter_8;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/3/30 18:17
 * @description 泛型方法
 **/
public class 泛型方法 {
    public static void main(String[] args) {
        System.out.println(getMiddle(1, 2, 3));
        System.out.println(getMiddle("Wwh", "is", "handsome"));
    }

    public static <T> T getMiddle(T ...a) {
        return a[a.length / 2];
    }
}

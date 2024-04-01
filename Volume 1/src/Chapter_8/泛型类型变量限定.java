package Chapter_8;

import java.io.Serializable;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/3/30 18:25
 * @description 泛型类型变量限定
 **/
public class 泛型类型变量限定 {
    public static void main(String[] args) {
        System.out.println(max(1, 2, 3));
        System.out.println(max(1.1, 2.2, 3.3));
    }

    public static <T extends Comparable & Serializable> T max(T ...a) {
        T largest = a[0];
        for (T t : a) {
            if (t.compareTo(largest) > 0) {
                largest = t;
            }
        }
        return largest;
    }
}

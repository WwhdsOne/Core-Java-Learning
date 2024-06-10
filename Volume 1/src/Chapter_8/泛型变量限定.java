package Chapter_8;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/5/12 上午11:45
 * @description
 **/
public class 泛型变量限定 {
    public static void main(String[] args) {
        var list = new ArrayList<Integer>();
        addIntegers(list);
        addIntegers(list);
        processNumbers(list);
    }

    public static void processNumbers(List<? extends Number> list) {
        for (Number num : list) {
            System.out.println(num);
        }
    }

    public static void addIntegers(List<? super Integer> list) {
        list.add(1);
    }
}

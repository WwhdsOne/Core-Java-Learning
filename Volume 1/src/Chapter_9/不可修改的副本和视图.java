package Chapter_9;

import java.util.*;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/3/30 23:28
 * @description 不可修改的副本和视图
 **/
public class 不可修改的副本和视图 {
    public static void main(String[] args) {
        var staff = new ArrayList<Integer>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        var view = staff.subList(0, 3);
        System.out.println(view); // [1, 2, 3]
        view.clear();
        System.out.println(view); // []
        System.out.println(staff); // [4, 5, 6, 7, 8, 9, 10]

    }
}

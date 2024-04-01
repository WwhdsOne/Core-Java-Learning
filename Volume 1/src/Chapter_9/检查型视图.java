package Chapter_9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/3/31 16:09
 * @description 检查型视图
 **/
public class 检查型视图 {
    public static void main(String[] args) {
        var staff = new ArrayList<Integer>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        var view = Collections.checkedList(staff, Integer.class);
        System.out.println(view); // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        view.add(11);
        System.out.println(view);
        //view.add("12"); // 主线程中的异常 java.lang.ClassCastException：尝试将一个 java.lang.String 类型的元素插入到元素类型为 java.lang.Integer 的集合中
    }
}

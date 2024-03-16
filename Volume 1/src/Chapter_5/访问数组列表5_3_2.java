package Chapter_5;

import java.util.ArrayList;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/3/16 20:20
 * @description 5.3.2 访问数组列表 Core Java第一卷P189-192
 **/
public class 访问数组列表5_3_2 {
    public static void main(String[] args) {
        var staff = new ArrayList<Integer>();
        for ( int i = 0; i < 15; i++ ) {
            staff.add(i);
        }
        System.out.println(staff);
        //要设置数组列表中的元素,可以使用set方法
        staff.set(0, 100);
        //注意set元素的索引不能超过数组列表的大小
        //set元素必须修改已存在的元素

        //要获取数组列表中的元素,可以使用get方法
        System.out.println(staff);
        Integer num = staff.get(2);
        System.out.println("num = " + num);

        //使用toArray方法可以将数组列表转换为数组
        var a = new Integer[staff.size()];
        staff.toArray(a);
        System.out.println(a[0]);

        //可以使用add方法在数组列表中间插入元素
        staff.add((staff.size()) / 2, 100);
        System.out.println(staff);

        //类似的,可以使用remove方法删除数组列表中的元素
        staff.remove(0);
        System.out.println(staff);


    }
}

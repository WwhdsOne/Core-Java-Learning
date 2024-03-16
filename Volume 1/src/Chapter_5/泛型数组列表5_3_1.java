package Chapter_5;

import java.util.ArrayList;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/3/16 20:09
 * @description 5.3.1 泛型数组列表 Core Java第一卷P187-189
 **/
public class 泛型数组列表5_3_1 {
    public static void main(String[] args) {
        //构造一个泛型数组列表
        ArrayList<String> staff = new ArrayList<>();
        //Java10中
        //var staff = new ArrayList<String>();
        //如果使用var关键字,则必须在右边指定类型参数,否则编译器无法推断出类型,会生成一个ArrayList<Object>
        //如果没有使用var关键字,则可以省略右边类型参数
        //ArrayList<String> staff = new ArrayList<>();

        //如果能够估计数组列表的大小,可以在构造函数中指定初始容量
        staff.ensureCapacity(100);
        //也可以把初始容量传递给ArrayList构造器
        ArrayList<String> staff1 = new ArrayList<>(100);
        //size方法返回数组列表包含的实际元素个数
        System.out.println(staff.size());

        //一旦确定数组列表大小将保持恒定,可以调用trimToSize方法
        staff.trimToSize();
        //应当在确认不会再添加元素时调用trimToSize方法,因为这样可以节省内存

    }
}

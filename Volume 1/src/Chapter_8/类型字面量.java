package Chapter_8;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/3/30 20:01
 * @description 类型字面量
 **/
public class 类型字面量 {
    public static void main(String[] args) {
        var arrayList = new ArrayList<String>();
        var type = arrayList.getClass().getInterfaces();
        System.out.println(type);
    }
}


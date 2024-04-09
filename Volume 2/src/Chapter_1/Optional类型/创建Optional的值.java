package Chapter_1.Optional类型;

import java.util.Optional;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/4/9 下午4:18
 * @description 创建Optional的值
 **/
public class 创建Optional的值 {
    public static void main(String[] args) {
        var optional = Optional.of("Wwh"); // 创建一个非空的Optional对象

        optional = Optional.ofNullable(null); // 创建一个可能为空的Optional对象

        optional = Optional.empty(); // 创建一个空的Optional对象


    }
}

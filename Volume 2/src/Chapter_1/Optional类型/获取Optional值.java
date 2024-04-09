package Chapter_1.Optional类型;

import java.util.Optional;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/4/9 下午3:42
 * @description Optional类型
 **/
public class 获取Optional值 {
    public static void main(String[] args) {
        var optional = Optional.empty(); // 创建一个空的Optional对象
        String result = (String) optional.orElse("Tom");
        System.out.println(result);

        result = (String) optional.orElseGet(() -> "Wwh");
        System.out.println(result);

        try {
            result = (String) optional.orElseThrow(() -> new IllegalArgumentException("值为空"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


    }
}

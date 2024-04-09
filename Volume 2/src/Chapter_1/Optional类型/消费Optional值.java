package Chapter_1.Optional类型;

import java.util.Optional;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/4/9 下午3:54
 * @description 消费Optional值
 **/
public class 消费Optional值 {
    public static void main(String[] args) {
        var optional = Optional.of(666);
        optional.ifPresent(it -> System.out.println(it * 2 % 233));

        optional = Optional.empty();
        optional.ifPresentOrElse(
                it -> System.out.println(it * 2 % 233),
                () -> System.out.println("值为空")
        );
    }
}

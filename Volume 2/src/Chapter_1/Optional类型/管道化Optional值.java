package Chapter_1.Optional类型;

import java.util.Optional;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/4/9 下午4:00
 * @description 管道化Optional值
 **/
public class 管道化Optional值 {
    public static void main(String[] args) {
        var optional = Optional.of(666);
        var result = optional.map(it -> it * 2 % 233); // 132

        optional = Optional.empty();
        result = optional.map(it -> it * 2 % 233); // 结果为空

        var opt = Optional.of("666www");
        var res = opt.filter(it -> it.length() > 10); // 结果为空

        opt = Optional.of("666www"); // 666www


    }
}

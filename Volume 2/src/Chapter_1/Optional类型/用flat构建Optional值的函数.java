package Chapter_1.Optional类型;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/4/9 下午4:27
 * @description 用flat构建Optional值的函数
 **/
public class 用flat构建Optional值的函数 {
    public static void main(String[] args) {
        Optional<Double> result = f(4.0).flatMap(x -> Optional.of(x * x));
        System.out.println(result);
    }

    private static Optional<Double> f(Double t){
        return Optional.of(t);
    }


}


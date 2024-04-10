package Chapter_1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/4/10 下午4:37
 * @description 基本类型流
 **/
public class 基本类型流 {
    public static void main(String[] args) {
        基本类型流();
        range和rangeClosed方法();
    }

    private static void 基本类型流(){
        IntStream intStream = IntStream.of(1,2,3,4,5);
        intStream = Arrays.stream(new int[]{1,2,3,4,5});
    }

    private static void range和rangeClosed方法(){
        IntStream range = IntStream.range(0, 100); // 不包括上限
        range.forEach(System.out::println);
        range = IntStream.rangeClosed(0,100); // 包括上限
        range.forEach(System.out::println);
    }

    private static void boxed方法(){
        IntStream range = IntStream.rangeClosed(1,100);
        Stream<Integer> boxed = range.boxed();
        range = boxed.mapToInt(Integer::intValue);
    }


}

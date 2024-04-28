package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/4/28 上午11:04
 * @description 流分类
 **/
public class 流分类 {
    public static void main(String[] args) {
        //生成一个有100个大小在0-5之间的浮点数，开区间
        var randomNumbers = new ArrayList<Double>();
        for ( int i = 0; i < 100; i++ ) {
            randomNumbers.add(Math.random() * 5);
        }
        randomNumbers.stream().collect(Collectors.groupingBy(Double::intValue))
                .forEach((k, v) -> System.out.println(k + " -> " + v.size()));
    }
}

package Chapter_6.src.lambda表达式;

import java.time.LocalDate;
import java.util.*;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/3/22 17:15
 * @description 6.2.3 函数式接口 Core Java第一卷P256-257
 **/
public class 函数式接口6_2_3 {
    public static void main(String[] args) {
        // 函数式接口是只有一个抽象方法的接口
        // 通过lambda表达式来实现函数式接口
        var s = new Integer[10];
        Random random = new Random();
        for (int i = 0; i < s.length; i++) {
            s[i] = random.nextInt(100);
        }
        // 使用lambda表达式实现Comparator接口对数组进行排序
        Arrays.sort(s, (o1, o2) -> o1 - o2);

        //function包中还有一个接口Predicate
        //Predicate接口是一个函数式接口，它接受一个参数并返回一个boolean值
        //我们在使用removeIf方法时，就可以使用Predicate接口
        List<Integer> list = new ArrayList<>(Arrays.stream(s).toList());
        System.out.println(list);
        list.removeIf(integer -> integer > 50);
        System.out.println(list);

        //另一个有用的函数式接口Supplier,它不接受参数，返回一个值
        //我们可以使用Supplier接口来生成对象
        //考虑以下调用
        LocalDate day = LocalDate.of(2024, 3, 22);
        //假设这个day基本不会为Null
        LocalDate date = Objects.requireNonNullElse(day, LocalDate.now());
        //我们可以使用Supplier接口来生成对象,它会在调用时候才产生对象
        date = Objects.requireNonNullElseGet(day, () -> LocalDate.now());


    }
}

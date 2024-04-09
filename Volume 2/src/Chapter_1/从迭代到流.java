package Chapter_1;

import java.util.List;
import java.util.Random;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/4/9 上午8:11
 * @description 从迭代到流
 **/
public class 从迭代到流 {
    private static List<Integer> list;

    private static Random random = new Random();

    static {
        for ( int i = 0; i < 10; i++ ) {
            list.add(random.nextInt(100));
        }
    }
    public static void main(String[] args) {
        迭代遍历();
        流遍历();
        并行流遍历2();
    }
    public static void 迭代遍历() {
        int count = 0;
        for(var it:list){
            if(it % 2 == 0){
                count++;
            }
        }
        System.out.println(count);
    }

    public static void 流遍历() {
        long count = list.stream().filter(it -> it % 2 == 0).count();
        System.out.println(count);
    }

    public static void 并行流遍历2() {
        long count = list.parallelStream().filter(it -> it % 2 == 0).count();
        System.out.println(count);
    }


}

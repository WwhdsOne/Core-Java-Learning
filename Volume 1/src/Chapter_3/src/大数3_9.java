package Chapter_3.src;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/3/15 18:22
 * @description 3.9 大数 Core Java第一卷P77
 **/
public class 大数3_9 {
    public static void main(String[] args) {
        //BigInteger类,用于表示任意精度的整数
        BigInteger a = BigInteger.valueOf(100);
        System.out.println(a);
        BigInteger reallyBig = new BigInteger("22323875437594759357375837453593753957395");
        System.out.println(reallyBig);
        //还有一些常量
        System.out.println(BigInteger.ZERO);
        System.out.println(BigInteger.ONE);
        System.out.println(BigInteger.TEN);
        //大数之间的运算,都是返回一个新的对象,不会改变原来的对象
        //因为大数之间的运算是不可变的,所以不会有副作用
        //因为Java不支持运算符重载,所以大数之间的运算需要使用方法,不能使用运算符
        BigInteger c = a.add(BigInteger.ONE);
        System.out.println(c);
        //BigDecimal类,用于表示任意精度的浮点数
        BigDecimal d = BigDecimal.valueOf(100);
        System.out.println(d);
        BigDecimal e = new BigDecimal("23.54385438573957358");
        System.out.println(e);

        BigDecimal f = d.add(e);
        System.out.println(f);
    }
}

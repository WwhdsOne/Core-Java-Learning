package Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/4/22 下午7:16
 * @description TODO
 **/
public class 字符串 {
    public static void main(String[] args) {
        String s1 = new String("abc");
        String s2 = new String("abc");
        System.out.println(s1.intern() == s2.intern());
    }


}

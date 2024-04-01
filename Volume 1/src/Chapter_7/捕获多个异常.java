package Chapter_7;

import java.io.File;
import java.io.FileInputStream;
import java.io.StringWriter;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/3/26 18:53
 * @description 捕获多个异常
 **/
public class 捕获多个异常 {
    public static void main(String[] args) throws Exception {
        var t = new Throwable();
        var out = new StringWriter();
        t.printStackTrace();
    }
}

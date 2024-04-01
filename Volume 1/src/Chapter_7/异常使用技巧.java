package Chapter_7;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/3/26 19:59
 * @description 异常使用技巧
 **/
public class 异常使用技巧 {
    public static void main(String[] args) throws FileNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream("test.txt");
        Stack<Integer> stack = new Stack<>();
        try{
            for ( int i = 0; i < 10000000; i++ ) {
                var n = stack.pop();
                fileOutputStream.write(n);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (EmptyStackException e){
            throw new RuntimeException(e);
        }
    }
}

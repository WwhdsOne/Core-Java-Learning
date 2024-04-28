package Chapter_2.随机访问文件;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/4/12 下午5:30
 * @description 数据生成
 **/
public class 数据生成 {
    public static void main(String[] args) throws IOException {
        String path = "D:\\Programming_Learning\\Project\\Core Java\\Volume 2\\src\\Chapter_4\\随机访问文件\\文件.txt";
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(path));
        for(int i = 0; i < 100; i++){
            dataOutputStream.writeInt(i );
        }
        dataOutputStream.close();
    }
}

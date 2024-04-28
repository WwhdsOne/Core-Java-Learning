package Chapter_2.DataInput和DataOutput;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/4/12 下午4:53
 * @description DataInput和DataOutput
 **/
public class DataInput和DataOutput {
    public static void main(String[] args) throws IOException {
        String path = "D:\\Programming_Learning\\Project\\Core Java\\Volume 2\\src\\Chapter_4\\DataInput和DataOutput\\文件.txt";
        DataOutput dataOutput = new DataOutputStream(new FileOutputStream(path));
        dataOutput.writeInt(2);
        dataOutput.writeChars("w");

        DataInput dataInput = new DataInputStream(new FileInputStream(path));
        int i = dataInput.readInt();
        System.out.println(i);
        System.out.println(dataInput.readChar());


    }
}

package Chapter_3;

import java.util.Scanner;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/3/15 17:58
 * @description 3.5.9 switch表达式 Core Java第一卷P41-42
 **/
public class switch表达式_3_5_9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int seasonCode = in.nextInt();
        //Java 14引入了这种switch表达式
        String seasonName = switch (seasonCode) {
            case 1 -> "Spring";
            case 2 -> "Summer";
            case 3 -> "Autumn";
            case 4 -> "Winter";
            default -> "Invalid";
        };
    }
}

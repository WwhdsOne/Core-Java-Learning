package Chapter_3.src;

import java.util.Scanner;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/3/16 15:21
 * @description 3.8.5 switch语句 Core Java第一卷P71-75
 **/
public class switch语句3_8_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //switch中的直通意味着如果case匹配成功，那么后面的case也会执行
        //无直通行为使用->跟在case标签后面

        //无直通行为switch表达式
        String seasonName = sc.next();
        int numLetters = switch (seasonName){
            case "Spring" -> {
                System.out.println("Spring");
                //yield关键字与break类似,会终止执行,但是yield关键字可以返回一个值
                //要在switch表达式使用一个语句而不想有直通行为时,可以使用yield
                yield 6;
            }
            case "Summer","Winter" -> 6;
            case "Fall" -> 4;
            default -> 1;
        };
        System.out.println(numLetters);


        //无直通语句switch表达式
        switch (seasonName){
            case "Spring" -> System.out.println("Spring");
            case "Summer","Winter" -> System.out.println("Summer or Winter");
            case "Fall" -> System.out.println("Fall");
            default -> System.out.println("default");
        }

        //有直通行为的switch表达式
        numLetters = switch (seasonName){
            case "Spring" : System.out.println("Spring");
            case "Summer","Winter" : yield 6;
            case "Fall" : yield 4;
            default : yield 1;
        };
        System.out.println(numLetters);

        //有直通行为的switch语句
        switch (seasonName){
            case "Spring" : System.out.println("Spring");
            case "Summer","Winter" :
                numLetters = 6;
                break;
            case "Fall" :
                numLetters = 4;
                break;
            default : System.out.println("default");
        }


    }
}

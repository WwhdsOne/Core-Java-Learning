package Chapter_5.src;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/3/16 20:36
 * @description 5.5 可变参数 Core Java第一卷P196-197
 **/
public class 可变参数5_5 {
    public static void main(String[] args) {
        double m = max(3.1, 40.5, -5,-777,233.66);
        System.out.println("m = " + m);
    }

    public static double max(double ... values){
        double largest = Double.NEGATIVE_INFINITY;
        for (double v : values) {
            if (v > largest) {
                largest = v;
            }
        }
        return largest;
    }
}

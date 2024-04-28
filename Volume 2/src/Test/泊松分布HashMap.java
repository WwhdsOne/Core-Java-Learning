package Test;

import java.text.DecimalFormat;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/4/18 上午10:19
 * @description 泊松分布HashMap
 **/
public class 泊松分布HashMap {
    public static void main(String[] args) {
        double lambda = 0.5;
        DecimalFormat df = new DecimalFormat("#.##########"); // 保留10位小数
        for(int i = 0;i<10;i++){
            System.out.println("poisson:" + i + " = " + df.format(poisson(lambda,i)));
        }
    }

    private static double poisson(double lambda, int k) {
        return Math.pow(lambda, k) * Math.exp(-lambda) / factorial(k);
    }

    private static long factorial(int k) {
        if (k == 0) {
            return 1;
        } else {
            return k * factorial(k - 1);
        }
    }
}

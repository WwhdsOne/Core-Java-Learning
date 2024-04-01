package Chapter_6.src.lambda表达式.自定义运算类;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/3/30 18:00
 * @description TODO
 **/
public class 通过函数式接口实现自定义运算类 {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.addOperator("%", (a, b) -> a % b);
        System.out.println(calculator.getOperator().get("%").apply(5, 3));
        calculator.addOperator("😄", (a, b) -> (int) Math.pow(a,b));
        System.out.println(calculator.getOperator().get("😄").apply(5, 3));
    }
}

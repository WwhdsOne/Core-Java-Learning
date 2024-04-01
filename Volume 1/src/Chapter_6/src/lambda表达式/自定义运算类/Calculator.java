package Chapter_6.src.lambda表达式.自定义运算类;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/3/30 18:00
 * @description TODO
 **/
public class Calculator {

    Map<String, BiFunction<Integer, Integer, Integer>> operator = new HashMap<>();

    public Calculator() {
        this.operator.put("+", Integer::sum);
        this.operator.put("-", (a, b) -> a - b);
        this.operator.put("*", (a, b) -> a * b);
        this.operator.put("/", (a, b) -> a / b);
    }

    public void addOperator(String operator, BiFunction<Integer, Integer, Integer> function) {
        this.operator.put(operator, function);
    }

    public Map<String, BiFunction<Integer, Integer, Integer>> getOperator() {
        return operator;
    }
}

package Chapter_9;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/3/30 23:15
 * @description 小集合
 **/
public class 小集合 {
    public static void main(String[] args) {
        List<String> names = List.of("Peter", "Paul", "Mary");
        Set<Integer> numbers = Set.of(2, 3, 5, 7, 11);
        Map<String, Integer> scores = Map.of("Peter", 2, "Paul", 3, "Mary", 5);
        Map<String, String> translations = Map.ofEntries(
                Map.entry("book", "Buch"),
                Map.entry("pen", "Stift"),
                Map.entry("computer", "Computer")
        );

        var names2 = new ArrayList<String>(names);

    }
}

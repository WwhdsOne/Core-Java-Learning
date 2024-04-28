package Chapter_1;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.mapping;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/4/10 下午1:07
 * @description 群组和分区
 **/
public class 群组和分区 {
    public static void main(String[] args) {
        语言流转映射表_重复键_合并_使用groupingBy();

        语言流转映射表_重复键_合并_使用partitioningBy();
    }

    private static void 语言流转映射表_重复键_合并_使用groupingBy() {
        Stream<Locale> availableLocales = Stream.of(Locale.getAvailableLocales());
        Map<String, Set<String>> collect = availableLocales.collect(
                Collectors.groupingBy(
                        Locale::getDisplayCountry,
                        mapping(Locale::getDisplayLanguage, Collectors.toSet())
                ));
        System.out.println(collect);
    }

    private static void 语言流转映射表_重复键_合并_使用partitioningBy() {
        Stream<Locale> availableLocales = Stream.of(Locale.getAvailableLocales());
        //按照语言分组
        //partitioningBy是groupingBy的特殊情况，只有两个组，一个是true，一个是false
        Map<Boolean, List<Locale>> collect = availableLocales.collect(
                Collectors.partitioningBy(l -> l.getLanguage().equals("zh")));
        System.out.println(collect.get(true));
    }

}

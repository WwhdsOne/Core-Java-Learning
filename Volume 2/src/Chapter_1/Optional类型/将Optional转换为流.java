package Chapter_1.Optional类型;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/4/9 下午4:44
 * @description 将Optional转换为流
 **/
public class 将Optional转换为流 {

    private static Random random = new Random();
    public static void main(String[] args) {
        var list = Stream.generate(() -> String.valueOf(random.nextInt(10000)))
                .limit(10)
                .toList();
        Stream<User> users = list.stream().map(将Optional转换为流::lookup)
                .filter(Optional::isPresent)
                .map(Optional::get);
        Stream<User> userStream = list.stream().map(将Optional转换为流::lookup)
                .flatMap(Optional::stream);
    }

    private static Optional<User> lookup(String id){
        return Optional.of(new User(id));
    }
}

class User{
    private String id;

    public User(String id) {
        this.id = id;
    }
}

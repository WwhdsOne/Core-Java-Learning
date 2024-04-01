package Chapter_8;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/3/30 18:13
 * @description 泛型类Pair示例
 **/
public class Pair<T, U> {
    private T first;
    private U second;

    public Pair() {
        this.first = null;
        this.second = null;
    }

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public U getSecond() {
        return second;
    }

    public void setSecond(U second) {
        this.second = second;
    }
}

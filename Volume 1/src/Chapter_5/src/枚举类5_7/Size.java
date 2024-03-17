package Chapter_5.src.枚举类5_7;

public enum Size {
    SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");

    private String abbreviation;

    //构造器只是在构造枚举常量时调用
    //枚举的构造器总是私有的
    Size(String s) {
        this.abbreviation = s;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
}

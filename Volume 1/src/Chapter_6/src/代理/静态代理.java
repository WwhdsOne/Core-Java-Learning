package Chapter_6.src.代理;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/3/24 19:02
 * @description 补充Core Java第一卷内容
 **/
public class 静态代理 {
    public static void main(String[] args) {
        PersonProxy personProxy = new PersonProxy(new Person());
        personProxy.eat();
    }
}

interface Eat {
    void eat();
}

class Person implements Eat {

    @Override
    public void eat() {
        System.out.println("吃饭");
    }
}

class PersonProxy implements Eat{

    private final Eat person;

    public PersonProxy(Eat person) {
        this.person = person;
    }

    @Override
    public void eat() {
        System.out.println("吃饭前洗手");
        person.eat();
        System.out.println("吃饭后洗碗");
    }
}




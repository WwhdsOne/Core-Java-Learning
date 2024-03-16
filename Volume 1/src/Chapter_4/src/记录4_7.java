package Chapter_4.src;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/3/16 17:04
 * @description 4.7 记录 Core Java第一卷P134-138
 **/
public class 记录4_7 {
    //JDK 14引入了一种新的引用类型,用于表示不可变的数据
    //最终版本于JDK 16中发布

    public static void main(String[] args) {
        var p = new Point(3,4);
        System.out.println(p.x());
        System.out.println(p.y());//每个记录还有三个自动定义的方法toString,equals和hashCode
        System.out.println(p);
        System.out.println(p.hashCode());
        System.out.println(p.equals(new Point(3,4)));
    }
}
//记录有点像类,但是记录是不可变的,它的字段是final的,并且记录的方法是自动生成的

//且每个实例都有访问器方法
//注意它的访问器方法名与实例名相同
//每个记录还有三个自动定义的方法toString,equals和hashCode
record Point(double x,double y){
//    这个类有一个构造器
//    public Point(double x,double y);
//    有以下访问器方法
//    public double y(){
//        return y;
//    }
//    public double x(){
//        return x;
//    }
    //每个方法都是可以自己定义版本只要有相同的参数和返回类型
    //可以为记录添加自定义方法
    public double distance(){
        //Math.hypot(x, y)是Java中的一个方法，用于计算直角三角形的斜边长度
        return Math.hypot(x,y);
    }

    //记录也可以有静态字段和静态方法
    public static Point origin = new Point(0,0);
    public static Point getOrigin(){
        return origin;
    }
}

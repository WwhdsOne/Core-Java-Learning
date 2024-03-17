package Chapter_5.src.密封类5_8;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/3/17 20:04
 * @description 5.8 密封类 Core Java第一卷P203-208
 **/
public class 密封类5_8 {
    public static void main(String[] args) {
        //除非一个类声明为final
        //否则可以使用extends关键字来扩展它
        //如果想对它有更多控制权,可以使用sealed关键字
        //在Java中,密封类是一种特殊的类,它的子类受到严格的限制,它可以控制哪些类可以扩展它
        //Java 15作为一个预览特性,引入了密封类,并在Java 17中正式发布

        //密封类声明
        //sealed关键字用于声明一个密封类
        //permits子句指定了哪些类可以扩展这个类
        //在这个例子中,actGame, strategyGame, rpgGame是Game的子类
        //这个类是抽象的,所以不能实例化
        //但是可以扩展它

        //如果一个密封类的子类是非final的,那么它可以有子类
        //但是这些子类必须在permits子句中声明
        //一个密封类的子类必须是可访问的
        //密封类子类必须指定它是sealed、final还是允许继续派生子类、对于最后一种情况，必须指定允许继续派生的子类
        //如果一个类是sealed的，那么它的子类必须在同一个包中

        Game actgame = new actGame();
        Game strategygame = new strategyGame();
        Game rpggame = new rpgGame();

        //如下方式便不能扩展子类

//        class RougelikeGame extends Game{
//            //actGame是Game的子类
//            //它是final的,所以不能再有子类
//            String name = "actGame";
//        }

    }
}



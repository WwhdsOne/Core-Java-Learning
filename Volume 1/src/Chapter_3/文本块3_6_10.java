package Chapter_3;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/3/15 18:12
 * @description 3.6.10 文本块 Core Java第一卷P54-55
 **/
public class 文本块3_6_10 {

    public static void main(String[] args) {
        //Java 15引入了这种文本块
        String query = """
                SELECT "EMP_ID", "LAST_NAME" FROM "EMPLOYEE_TB"
                WHERE "CITY" = 'INDIANAPOLIS'
                ORDER BY "EMP_ID", "LAST_NAME";
                """;
        System.out.println(query);
    }
}

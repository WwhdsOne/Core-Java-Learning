package Chapter_4.src;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;

/**
 * @author Wwh
 * @ProjectName Core Java
 * @dateTime 2024/3/16 15:37
 * @description 4.2.2 Java类库中的LocalDate类 Core Java第一卷P99
 **/
public class Java类库中的LocalDate类4_2_2 {
    public static void main(String[] args) {
        //打印日历
        LocalDate date = LocalDate.now().plusMonths(1);
        int month = date.getMonthValue();
        int today = date.getDayOfMonth();
        //将日期设置为这个月的第一天
        date = date.minusDays(today - 1);
        DayOfWeek weekday = date.getDayOfWeek();
        int value = weekday.getValue(); // 1 = Monday, ... 7 = Sunday

        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        for ( int i = 1; i < value; i++ ) {
            System.out.print("    ");
        }
        while ( date.getMonthValue() == month ) {
            System.out.printf("%3d", date.getDayOfMonth());
            if ( date.getDayOfMonth() == today ) {
                System.out.print("*");
            } else {
                System.out.print(" ");
            }
            date = date.plusDays(1);
            if ( date.getDayOfWeek().getValue() == 1 ) {
                System.out.println();
            }
        }
    }

}

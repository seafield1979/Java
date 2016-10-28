import java.io.*;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

class TestTime {
    public static void main(String[] args) {
        System.out.println("TestTime");

        // 第１引数を整数に変換する
        int mode = 0;
        try {
            mode = Integer.parseInt(args[1]);
        } catch (ArrayIndexOutOfBoundsException e) {

        }

        switch (mode) {
            case 1:
                test1();
                break;
            case 2:
                test2();
                break;
            case 3:
                test3();
                break;
        }
    }
    public static void test1() {
        // タイムゾーンを指定しない場合システムのタイムゾーンの時間が返る
        Calendar cal1 = Calendar.getInstance();
        showTime(cal1);

        // タイムゾーンを指定
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Asia/Tokyo"), Locale.JAPAN);
        showTime(calendar);
    }

    // 日時の加算、減算
    public static void test2() {
        Calendar calendar = Calendar.getInstance();
        
        // 10年後
        calendar.add(Calendar.YEAR, 10);
        showTime(calendar);

        // 10年前
        Calendar calendar2 = Calendar.getInstance();
        calendar2.add(Calendar.YEAR, -10);
        showTime(calendar2);
    }

    // 日付を設定
    public static void test3() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, // Year
            8,  // Month
            1,  // Day of Month
            10, // Hour of Day
            0,  // Minute
            0); // Second
        showTime(calendar);
    }
    
    // Calendarオブジェクトに設定された日時を表示する
    public static void showTime(Calendar cal) {
        System.out.println(String.format("%04d/%02d/%02d %02d:%02d:%02d",
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH)+1,  // 0が1月に相当するので +1する
                cal.get(Calendar.DAY_OF_MONTH),
                cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE),
                cal.get(Calendar.SECOND)));
    }

}
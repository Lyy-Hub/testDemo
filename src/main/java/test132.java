import java.text.SimpleDateFormat;

import java.util.Date;

/**
 * Created by liyueyang on 2019/4/5.
 */
public class test132 {
    public static void main(String[] args) {
        long timestamp = new Date().getTime();
        System.out.println(timestamp);
        SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //设置格式
        String timeText = format.format(timestamp);
        System.out.println(timeText);//获得带格式的字符串
    }
}

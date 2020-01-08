import javax.xml.crypto.Data;
import java.util.Calendar;
import java.util.Date;

public class SystemArrayCopy {
    public static void main(String[] args) {
        /*String[] qq = new String[]{"1","2"};
        String[] qqq=new String[3];
        System.out.println(qq.length);
        System.out.println("开始:"+qqq[0]);
        System.arraycopy(qq,0,qqq,0,qq.length);
        System.out.println("结束："+qqq[2]);*/
//        boolean qq = isLastDayOfMonth(new Date());
//        System.out.println(qq);


        System.out.println(Calendar.getInstance().getTime());
        Calendar aaa = getSolrTime();
        System.out.println(aaa.getTime());
    }

    /**
     * 判断该日期是否是该月的最后一天
     *
     * @param date 需要判断的日期
     * @return
     */
    public static boolean isLastDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH) == calendar
                .getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    public static Calendar getSolrTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, 8);
        return calendar;
    }
}

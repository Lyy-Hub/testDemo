package 流水号;

import org.coodex.util.Profile;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liyueyang on 2019/5/28.
 */
public class serialnumber {

    private static Profile profile = Profile.getProfile("upload.properties");
    /**
     * 获取现在时间
     * @return返回字符串格式yyyyMMddHHmmss
     */
    public static String getStringDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String dateString = formatter.format(currentTime);
        //System.out.println("TIME:::"+dateString);
        return dateString;
    }
    /**
     * 由年月日时分秒+3位随机数
     * 生成流水号
     * @return
     */
    public static String Getnum(){
        // 读取配置文件
        String vioDataSeq = profile.getString("num");
        System.out.println(vioDataSeq);
        //  + 1 操作
        String housiwei = addOne(vioDataSeq);
        System.out.println(housiwei);
        // 修改配置文件
        profile.setString("num", housiwei);
        String t = getStringDate();
        String serial = t + housiwei;
        return serial;
    }
    public static String addOne(String testStr){
        String[] strs = testStr.split("[^0-9]");//根据不是数字的字符拆分字符串
        String numStr = strs[strs.length-1];//取出最后一组数字
        if(numStr != null && numStr.length()>0){//如果最后一组没有数字(也就是不以数字结尾)，抛NumberFormatException异常
            int n = numStr.length();//取出字符串的长度
            int num = Integer.parseInt(numStr)+1;//将该数字加一
            String added = String.valueOf(num);
            n = Math.min(n, added.length());
            //拼接字符串
            return testStr.subSequence(0, testStr.length()-n)+added;
        }else{
            throw new NumberFormatException();
        }
    }
    //主方法测试
    public static void main(String[] args) {
       /* String m = Getnum();
        System.out.println(m);*/
        Map map = new HashMap<String ,String>();
        if(map.size() > 0 && map.isEmpty()){

            System.out.println("11");
        }
    }

}

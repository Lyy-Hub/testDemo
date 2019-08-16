package 流水号;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * Created by liyueyang on 2019/5/28.
 */
public class Serialnumber {
    /**
     * 获取现在时间
     *
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
     *
     * @return
     */
    public static String Getnum() throws IOException {
        // 读取配置文件
        String rootPath = System.getProperty("user.dir").replace("\\", "/");
        FileInputStream in = new FileInputStream(rootPath + "\\src\\main\\java\\流水号\\upload.properties");
        Properties properties = new Properties();
        try {
            properties.load(in);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String date = properties.getProperty("date");
        String time = getStringDate();
        ///保存属性到upload.properties文件
        FileOutputStream oFile = new FileOutputStream(rootPath + "\\src\\main\\java\\流水号\\upload.properties", false);//true表示追加打开
        if (!date.equals(time)) {
            properties.setProperty("num", "0000");
            properties.setProperty("date", time);
        }
        String seq = properties.getProperty("num");
        //  num + 1 操作
        String housiwei = addOne(seq);
        // 修改配置文件
        properties.setProperty("num", housiwei);
        properties.setProperty("date", time);
        properties.store(oFile, null);
        oFile.close();
        String serial = time + housiwei;
        return serial;
    }

    public static String addOne(String testStr) {
        String[] strs = testStr.split("[^0-9]");//根据不是数字的字符拆分字符串
        String numStr = strs[strs.length - 1];//取出最后一组数字
        if (numStr != null && numStr.length() > 0) {//如果最后一组没有数字(也就是不以数字结尾)，抛NumberFormatException异常
            int n = numStr.length();//取出字符串的长度
            int num = Integer.parseInt(numStr) + 1;//将该数字加一
            String added = String.valueOf(num);
            n = Math.min(n, added.length());
            //拼接字符串
            return testStr.subSequence(0, testStr.length() - n) + added;
        } else {
            throw new NumberFormatException();
        }
    }

    //主方法测试
    public static void main(String[] args) throws IOException {
        String m = Getnum();
        System.out.println(m);
    }

}

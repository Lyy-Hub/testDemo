import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.poi.ss.formula.functions.T;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by liyueyang on 2019/4/5.
 */
public class Test132 {
    public static void main(String[] args) {

        String template = "${name},${sex},${birthYear}年出生,${graduateYear}年毕业于${university}。";
        Map<String, String> params = new HashMap<>();
        params.put("name", "张三");
        params.put("sex", "男");
        params.put("birthYear", "1990");
        params.put("graduateYear", "2012");
        params.put("university", "清华大学");

        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            String result = render(template, params);
            if (i == 9999) {
                System.out.println(result);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("cost time:" + (end - start) + "ms");
        start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            String result = render2(template, params);
            if (i == 9999) {
                System.out.println(result);
            }
        }
        end = System.currentTimeMillis();
        System.out.println("cost time:" + (end - start) + "ms");
    }

    public static String render(String template, Map<String, String> params) {
        //使用builder拼接，比string相加提高不少效率
        StringBuilder builder = new StringBuilder();
        //定义控制变量
        boolean $Begin = false;
        boolean paramBegin = false;
        //boolean paramEnd = false;
        StringBuilder key = null;
        //循环匹配
        for (int i = 0; i < template.length(); i++) {
            char c = template.charAt(i);
            //开始标识
            if (c == '$') {
                $Begin = true;
            }
            if ($Begin && c == '{') {
                paramBegin = true;
                builder.deleteCharAt(builder.length() - 1); //删除添加的$字符
                key = new StringBuilder();
                continue;
            }
            //参数key
            if (paramBegin && c != '}') {
                if (c == '{') {
                    System.out.println("模板格式错误！位置：" + i);
                } else {
                    key.append(c);
                }
                continue;
            }

            //结束标识
            if (paramBegin && c == '}') {
                //paramEnd = true;
                //拼接参数key对应的值
                builder.append(params.get(key.toString()));
                //重置控制变量
                $Begin = false;
                paramBegin = false;
                //paramEnd = false;
                continue;
            }
            //默认情况
            builder.append(c); //添加字符
        }
        return builder.toString();
    }

    public static String render2(String template, Map<String, String> params) {
        for (Map.Entry<String, String> entry : params.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            template = template.replace("${" + key + "}", value);
        }
        return template;
    }
}

package jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;

/**
 * Created by liyueyang on 2019/5/15.
 */
public class jackson {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        User user = new User("001", "李越洋", "123456",
                18, "1095285545@qq.com", 1, "001001");
        // 对象转json字符串
        String qq = objectMapper.writeValueAsString(user);
        System.out.println(qq);
        // json字符串转对象
        User qqq = objectMapper.readValue(qq,User.class);
        System.out.println(qqq);
        System.out.println("----------------------------------");
        // 对象转xml
        XmlMapper xmlMapper = new XmlMapper();
        String xmlString = xmlMapper.writeValueAsString(user);
        System.out.println(xmlString);
        // xml转对象
        User qqqq = xmlMapper.readValue(xmlString,User.class);
        System.out.println(qqqq);
    }
}

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
        User user = new User();
        user.setAge(1);
        user.setState(0);
        // 对象转json字符串
        String qq = objectMapper.writeValueAsString(user);
        System.out.println(qq);
        // json字符串转对象
        User qqq = objectMapper.readValue(qq,User.class);
        System.out.println(qqq.getState());
        System.out.println("----------------------------------");
        // 对象转xml
        XmlMapper xmlMapper = new XmlMapper();
        String xmlString = xmlMapper.writeValueAsString(user);
        System.out.println(xmlString);
        User qqqq = xmlMapper.readValue(xmlString,User.class);
        System.out.println(qqqq.getAge());
    }
}

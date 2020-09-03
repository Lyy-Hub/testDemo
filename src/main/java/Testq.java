import com.alibaba.fastjson.JSONObject;

import javax.jws.WebResult;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Testq {
    public static String checkParam(String... paramKeyArray){
        return paramKeyArray.toString();
    }

    public static void main(String[] args) {
        String webResult = checkParam();
        System.out.println(webResult);
    }
}

package Json解析相关.gson;

import Json解析相关.jackson.User;

/**
 * Created by liYueYang on 2019/9/18.
 */
public class Gson {
    public static void main(String[] args) {
        com.google.gson.Gson gson = new com.google.gson.Gson();
        User user = new User("001", "李越洋", "123456",
                18, "1095285545@qq.com", 1, "001001");
        // 生成gson
        String jsonObject = gson.toJson(user);
        System.out.println(jsonObject);
        System.out.println("---------------------------");
        User user1 = gson.fromJson(jsonObject, User.class);
        System.out.println(user1);
    }
}

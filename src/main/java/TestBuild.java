import java.util.ArrayList;
import java.util.List;

/**
 * Created by liYueYang on 2022/4/1.
 */
public class TestBuild {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("11","22",18));
        System.out.println(users.size());
    }
}

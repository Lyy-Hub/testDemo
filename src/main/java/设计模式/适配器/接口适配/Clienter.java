package 设计模式.适配器.接口适配;

/**
 * Created by liYueYang on 2019/10/8.
 */
public class Clienter {
    public static void main(String[] args) {
        A a = new Ashili();
        a.a();
        a.d();
    }
}

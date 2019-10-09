package 设计模式.适配器.接口适配;

/**
 * Created by liYueYang on 2019/10/8.
 */
public class Ashili extends Adapter {
    public void a(){
        System.out.println("实现A方法被调用");
    }
    public void d(){
        System.out.println("实现d方法被调用");
    }
}

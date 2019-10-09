package 设计模式.适配器.对象适配;

import 设计模式.适配器.MicroUSB;
import 设计模式.适配器.TypeC;
import 设计模式.适配器.TypeCImpl;

/**
 * Created by liYueYang on 2019/10/8.
 */
public class App {
    public static void main(String[] args) {
        TypeC typeC = new TypeCImpl();
        MicroUSB microUSB = new Adapter(typeC);
        microUSB.isMicroUSB();
    }
}

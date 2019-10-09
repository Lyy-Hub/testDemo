package 设计模式.适配器.类适配;

import 设计模式.适配器.MicroUSB;

/**
 * Created by liYueYang on 2019/10/8.
 */
public class App {
    public static void main(String[] args) {
        MicroUSB microUSB = new Adapter();
        microUSB.isMicroUSB();
    }
}

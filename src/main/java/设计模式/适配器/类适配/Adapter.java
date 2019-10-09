package 设计模式.适配器.类适配;

import 设计模式.适配器.MicroUSB;
import 设计模式.适配器.TypeCImpl;

/**
 * Created by liYueYang on 2019/10/8.
 */
public class Adapter extends TypeCImpl implements MicroUSB {
    @Override
    public void isMicroUSB() {
        isTypeC();
    }
}

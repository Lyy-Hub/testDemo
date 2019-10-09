package 设计模式.适配器.对象适配;

import 设计模式.适配器.MicroUSB;
import 设计模式.适配器.TypeC;

/**
 * Created by liYueYang on 2019/10/8.
 */
public class Adapter implements MicroUSB {
    private TypeC typeC;

    public Adapter(TypeC typeC) {
        this.typeC = typeC;
    }

    @Override
    public void isMicroUSB() {
        typeC.isTypeC();
    }
}

package 流水号;

import java.util.UUID;

/**
 * Created by liYueYang on 2019/8/16.
 */
public class TestOrder {
    public static String getOrderIdByUUId() {
        int machineId = 1;
        int hashCodev = UUID.randomUUID().toString().hashCode();
        System.out.println(UUID.randomUUID().toString(

        ));
        if (hashCodev < 0) {
            hashCodev = -hashCodev;
        }
        //"%015d"的意思：0代表不足位数的补0，这样可以确保相同的位数，15是位数也就是要得到到的字符串长度是15，d代表数字。  
        return machineId + String.format("%015d", hashCodev);
    }

    public static void main(String[] args) {
        String one = getOrderIdByUUId();
        String two = getOrderIdByUUId();
        String three = getOrderIdByUUId();
        System.out.println(one);
        System.out.println(two);
        System.out.println(three);
    }


}

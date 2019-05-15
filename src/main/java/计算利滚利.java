import java.math.BigDecimal;

/**
 * Created by liyueyang on 2018/11/23.
 */
public class 计算利滚利 {
    public static void main(String[] args) {
        double principal = 10000000; // 本金
        final double begin  = principal;
        double years = 1; // 年限
        double interest = 0.0005; // 日利率
        BigDecimal bigDecimal = null; // 格式转换
        // 把今天的本息之和作为明天的本金
        for(int i = 0; i < years * 366; i++){
            principal += principal * interest;
            bigDecimal =new BigDecimal(principal+"");
        }
        System.out.println(begin + "元利滚利（日利率：0.05%）," + years +
                "年后本息总和为：" + bigDecimal + "元");
    }
}

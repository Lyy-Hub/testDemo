package JDK8;

/**
 * Created by liYueYang on 2020/3/19.
 */
public class FormulaImpl implements Formula {

    @Override
    public double calculate(int a) {
        return 0;
    }


    public static void main(String[] args) {
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return 0;
            }
        };
        System.out.println(formula.calculate(100));     // 100.0
        System.out.println(formula.sqrt(16)); // 4.0



        String aa = "123";
        String aaa = new String("123");
    }
}

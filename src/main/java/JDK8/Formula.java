package JDK8;

/**
 * Created by liYueYang on 2020/3/19.
 */
public interface Formula{

    double calculate(int a);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}

import org.apache.poi.ss.formula.functions.T;

/**
 * Created by liYueYang on 2019/9/20.
 */
public class GlmapperGeneric<T> {
    private T t;

    public void set(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public static void main(String[] args) {

    }

    public void noSpecifyType() {
        GlmapperGeneric glmapperGeneric = new GlmapperGeneric();
        glmapperGeneric.set("test");
        String test = (String) glmapperGeneric.get();
        System.out.println(test);
    }

    public void specifyType() {
        GlmapperGeneric<String> glmapperGeneric = new GlmapperGeneric();
        glmapperGeneric.set("test");
        String test = glmapperGeneric.get();
        System.out.println(test);
    }

    public class testqwe<T>{

    }
}

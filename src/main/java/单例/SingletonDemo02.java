package 单例;

/**
 * Created by liYueYang on 2019/9/18.
 */
//懒汉式
public class SingletonDemo02 {

    //类初始化时，不会初始化该对象，真正需要使用的时候才会创建该对象。
    private static SingletonDemo02 singletonDemo02;

    private SingletonDemo02() {
        System.out.println("SingletonDemo02初始化");
    }

    public synchronized static SingletonDemo02 getInstance() {
        System.out.println("getInstance");
        if (singletonDemo02 == null) {
            singletonDemo02 = new SingletonDemo02();
        }
        return singletonDemo02;
    }

    public static void main(String[] args) {
        SingletonDemo02 s1 = SingletonDemo02.getInstance();
        SingletonDemo02 s2 = SingletonDemo02.getInstance();
        System.out.println(s1 == s2);
    }

}

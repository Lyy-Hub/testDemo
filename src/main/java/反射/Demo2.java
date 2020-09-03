package 反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by liYueYang on 2020/3/4.
 */
public class Demo2 {
    @SuppressWarnings("all")
    public static void main(String[] args) throws Exception {
        // 另一个com.sg.myReflection.bean包下的User类
        String path = "反射.User";
        try {
            Class clazz = Class.forName(path);

            // 获取类名
            String strName01 = clazz.getName();// 获取完整类名com.sg.myReflection.bean.User
            String strName02 = clazz.getSimpleName();// 直接获取类名 User

            // 获取属性
            Field[] field01 = clazz.getFields(); // 返回属性为public的字段
            Field[] field02 = clazz.getDeclaredFields(); // 返回所有的属性
            Field field03 = clazz.getDeclaredField("id"); // 获取属性为id的字段

            // 获取普通方法
            Method[] Method01 = clazz.getDeclaredMethods(); // 返回public方法
            Method method = clazz.getDeclaredMethod("getId", null); // 返回getId这个方法，如果没有参数，就默认为null

            // 获取构造方法
            User u1 = (User) clazz.newInstance(); // 获取无参的构造函数这里的前提的保证类中应该有无参的构造函数
            // 获取参数为(int,String,int)的构造函数
            Constructor c2 = clazz.getDeclaredConstructor(int.class, String.class, int.class);
            // 通过有参构造函数创建对象
            User u2 = (User) c2.newInstance(1001, "小小", 18);

            // 通过反射调用普通方法
            User u3 = (User) clazz.newInstance();
            Method method03 = clazz.getDeclaredMethod("setId", int.class);
            method.invoke(u3, 1002); // 把对象u3的id设置为1002

            // 通过反射操作普通的属性
            User u4 = (User) clazz.newInstance();
            Field f = clazz.getDeclaredField("name");
            f.setAccessible(true); // 设置属性可以直接的进行访问
            f.set(u4, "石头");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
package 反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by liyueyang on 2019/5/8.
 */
public class ReflectClass {
    private final static String TAG = "peter.log.ReflectClass";

    // 创建对象
    public static String reflectNewInstance() {
        try {
            Class<?> classBook = Class.forName("反射.Book");
            Object objectBook = classBook.newInstance();
            Book book = (Book) objectBook;
            book.setName("Android进阶之光");
            book.setAuthor("刘望舒");
            return book.getName() + " - "+ book.getAuthor();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    // 反射私有的构造方法
    public static String reflectPrivateConstructor() {
        try {
            Class<?> classBook = Class.forName("反射.Book");
            Constructor<?> declaredConstructorBook = classBook.getDeclaredConstructor(String.class,String.class);
            declaredConstructorBook.setAccessible(true);
            Object objectBook = declaredConstructorBook.newInstance("Android开发艺术探索","任玉刚");
            Book book = (Book) objectBook;
            return book.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    // 反射私有属性
    public static String reflectPrivateField() {
        try {
            Class<?> classBook = Class.forName("反射.Book");
            Object objectBook = classBook.newInstance();
            Field fieldTag = classBook.getDeclaredField("TAG");
            fieldTag.setAccessible(true);
            String tag = (String) fieldTag.get(objectBook);
            return tag;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    // 反射私有方法
    public static String reflectPrivateMethod() {
        try {
            Class<?> classBook = Class.forName("反射.Book");
            Method methodBook = classBook.getDeclaredMethod("declaredMethod",int.class);
            methodBook.setAccessible(true);
            Object objectBook = classBook.newInstance();
            String string = (String) methodBook.invoke(objectBook,0);
            return string;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}

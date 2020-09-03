package 反射;

/**
 * Created by liYueYang on 2020/3/4.
 */
public class User {
    // 学号
    public int id;
    // 名字
    String name;
    // 年龄
    int age;

    public User() {
        super();
    }

    public User(int id, String name, int age) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}

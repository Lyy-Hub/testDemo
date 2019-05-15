package Postgres;

/**
 * Created by liyueyang on 2019/1/21.
 */
public class Student {
    private String Id;
    private String Name;
    private String Sex;
    private String Age;

    Student(String Id,String Name, String Sex, String Age) {
        this.Id = Id; //default
        this.Name = Name;
        this.Sex = Sex;
        this.Age = Age;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }
}

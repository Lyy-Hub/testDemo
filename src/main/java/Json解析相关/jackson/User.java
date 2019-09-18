package Json解析相关.jackson;

/**
 * Created by liyueyang on 2019/5/15.
 */
public class User {
    private String id;

    private String userName;

    private String password;

    private Integer age;

    private String email;// 用户邮箱
    private Integer state;// 用户账号状态：0表示未激活，1表示激活
    private String code;// 激活码

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public User(String id, String userName, String password, Integer age, String email, Integer state, String code) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.age = age;
        this.email = email;
        this.state = state;
        this.code = code;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", state=" + state +
                ", code='" + code + '\'' +
                '}';
    }
}

package 二维码生成与解析.yi;

import Postgres.Student;

import java.util.List;

/**
 * Created by liYueYang on 2019/11/1.
 */
public class Teacher {
    private String id;
    private String name;
    private List<Stu> studentList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Stu> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Stu> studentList) {
        this.studentList = studentList;
    }
}

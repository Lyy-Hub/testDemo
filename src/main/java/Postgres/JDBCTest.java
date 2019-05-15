package Postgres;

/**
 * Created by liyueyang on 2019/1/21.
 */
public class JDBCTest {
    public static void main(String args[]) {
        JDBCOperation op = new JDBCOperation();
        //op.create();
        op.getAll();
        op.insert(new Student("001", "Achilles", "Male", "14"));
        op.insert(new Student("002", "Bean", "Fmale", "15"));
        op.getAll();
        op.update(new Student("002", "Bean", "", "7"));
        op.delete("Bean");
        op.getAll();
    }
}

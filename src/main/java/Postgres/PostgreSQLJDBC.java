package Postgres;

import MD5.MD5Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class PostgreSQLJDBC {
    public static void main( String args[] ) {
    Connection c = null;
    Statement stmt = null;
    try {
        Class.forName("org.postgresql.Driver");
        c = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/test",
                        "postgres", MD5Util.convertMD5("root"));
        System.out.println("Opened database successfully");

        stmt = c.createStatement();
        String sql= "CREATE TABLE STUDENTS " +
                "(ID TEXT PRIMARY KEY     NOT NULL ," +
                " NAME            TEXT    NOT NULL, " +
                " SEX             TEXT    NOT NULL, " +
                " AGE             TEXT    NOT NULL)";
        stmt.executeUpdate(sql);
        stmt.close();
        c.close();
    } catch ( Exception e ) {
        System.err.println( e.getClass().getName()+": "+ e.getMessage() );
        System.exit(0);
    }
    System.out.println("Table created successfully");
}
}
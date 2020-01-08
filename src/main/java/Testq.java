import java.io.*;

public class Testq {
    public static void main(String[] args) throws IOException {
        String fileName = "http://49.233.168.239:8002/3.png";
        File file = new File(fileName);
        System.out.println(file.exists());
        if (!file.exists()) {
            file.mkdirs();
        }
    }
}

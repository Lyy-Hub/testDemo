import java.io.*;

/**
 * Created by liYueYang on 2021/7/21.
 */
public class 文件复制 {

    public static void main(String[] args) {
        copy("G:\\tmp\\1.log", "G:\\tmp\\2.log", 10);
    }

    public static void copy(String source, String dest, int bufferSize) {
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(new File(source));
            out = new FileOutputStream(new File(dest));

            byte[] buffer = new byte[bufferSize];
            int len;
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("copy-end");
        }
    }
}

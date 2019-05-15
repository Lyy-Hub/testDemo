import java.util.HashMap;
import java.util.Map;

/**
 * Created by liyueyang on 2018/11/19.
 */
public class zuobiaochange {
    public static void main(String[] args) {
        Map aa = Convert_GCJ02_To_BD09(114.111,48.123);
        System.out.println(aa);
        Map aaa = Convert_BD09_To_GCJ02_RETURN_LNG(114.111,48.123);
        System.out.println(aaa);
    }

    public static Map Convert_GCJ02_To_BD09(double lat, double lon) {
        double x_pi = 3.14159265358979324 * 3000.0 / 180.0;
        Map m = new HashMap();
        double x = lon, y = lat;
        double z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * x_pi);
        double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * x_pi);
        lon = z * Math.cos(theta) + 0.0065;
        lat = z * Math.sin(theta) + 0.006;
        m.put("lon", lon);
        m.put("lat", lat);
        return m;
    }

    public static Map Convert_BD09_To_GCJ02_RETURN_LNG(double lat, double lng) {
        double x_pi = 3.14159265358979324 * 3000.0 / 180.0;
        double x = lng - 0.0065, y = lat - 0.006;
        double z = Math.sqrt(x * x + y * y) - 0.00002 * Math.sin(y * x_pi);
        double theta = Math.atan2(y, x) - 0.000003 * Math.cos(x * x_pi);
        lng = z * Math.cos(theta);
        lat = z * Math.sin(theta);
        Map m = new HashMap();
        m.put("lon", lng);
        m.put("lat", lat);
        return m;
    }
}

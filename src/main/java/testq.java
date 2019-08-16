
public class testq {
    public static void main(String[] args) {
        String ip1 = "22.10.168.192";
        String ip2 = "";
        String[] ipStr = ip1.split("\\.");
        for(int i = 0; i < ipStr.length; i++){
            ip2 += ipStr[ipStr.length - 1 - i] + ".";
        }
        System.out.println(ip2.substring(0,ip2.length() - 1));
    }
}

import java.util.Random;

public class 车牌号 {


    public static void main(String[] args) {
        int score = 1;
        switch (score){
            case 1:
                System.out.println(parkNo());
        }
    }
    public static String parkNo(){
        int count = 0;
        String carNo = "";
        while (count < 5) {
            long time = System.currentTimeMillis();
            Random random = new Random(time);
            String str = "abcdefghijklmnopqrstuvwxyz";
            char str2 = str.charAt(random.nextInt(26));
            int num = random.nextInt(10);
            //字母与数字的概率相同
            if (num < 5) {
                carNo += num;
            } else {
                carNo += str2;
            }
            count++;
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "车牌号是：" + carNo;
    }
}

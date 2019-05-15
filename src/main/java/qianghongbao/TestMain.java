package qianghongbao;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by liyueyang on 2019/1/24.
 */
public class TestMain {
    public static void main(String[] args) {
        int jine = 1000;
        int renshu = 10;
        for (int i = 0; i < 1; i++) {
            List<BigDecimal> moneys = math(BigDecimal.valueOf(jine), renshu);
            if (moneys != null) {
                BigDecimal b = new BigDecimal(0);
                String zongde = "";
                for (BigDecimal bigDecimal : moneys) {
                    System.out.print(bigDecimal + "  ");
                    zongde += bigDecimal + ",";
                    b = b.add(bigDecimal);
                }
                System.out.println("----发了"+b+"元，"+renshu+"个人抢----");
                String[] arr = zongde.split(",");
                Arrays.toString(arr);
                int[] aaa = sort(StringToInt(arr),0,renshu-1);
                System.out.println("渣渣王："+((double)aaa[0])/100 + "元  ");
                System.out.println("运气王："+((double)aaa[aaa.length-1])/100 + "元  ");
                System.out.println();
            }
        }
    }

    /**
     * 计算每人获得红包金额;最小每人0.01元
     * @param mmm 红包总额
     * @param number 人数
     * @return
     */
    public static List<BigDecimal> math(BigDecimal mmm, int number) {
        if (mmm.doubleValue() < number * 0.01) {
            return null;
        }
        Random random = new Random();
        // 金钱，按分计算 10块等于 1000分
        int money = mmm.multiply(BigDecimal.valueOf(100)).intValue();
        // 随机数总额
        double count = 0;
        // 每人获得随机点数
        double[] arrRandom = new double[number];
        // 每人获得钱数
        List<BigDecimal> arrMoney = new ArrayList<BigDecimal>(number);
        // 循环人数 随机点
        for (int i = 0; i < arrRandom.length; i++) {
            int r = random.nextInt((number) * 99) + 1;
            count += r;
            arrRandom[i] = r;
        }
        // 计算每人拆红包获得金额
        int c = 0;
        for (int i = 0; i < arrRandom.length; i++) {
            // 每人获得随机数相加 计算每人占百分比
            Double x = new Double(arrRandom[i] / count);
            // 每人通过百分比获得金额
            int m = (int) Math.floor(x * money);
            // 如果获得 0 金额，则设置最小值 1分钱
            if (m == 0) {
                m = 1;
            }
            // 计算获得总额
            c += m;
            // 如果不是最后一个人则正常计算
            if (i < arrRandom.length - 1) {
                arrMoney.add(new BigDecimal(m).divide(new BigDecimal(100)));
            } else {
                // 如果是最后一个人，则把剩余的钱数给最后一个人
                arrMoney.add(new BigDecimal(money - c + m).divide(new BigDecimal(100)));
            }
        }
        // 随机打乱每人获得金额
        Collections.shuffle(arrMoney);
        return arrMoney;
    }

    public static int[] sort(int[] a,int low,int high){
        int mid = (low+high)/2;
        if(low<high){
            sort(a,low,mid);
            sort(a,mid+1,high);
            //左右归并
            merge(a,low,mid,high);
        }
        return a;
    }

    public static void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high-low+1];
        int i= low;
        int j = mid+1;
        int k=0;
        // 把较小的数先移到新数组中
        while(i<=mid && j<=high){
            if(a[i]<a[j]){
                temp[k++] = a[i++];
            }else{
                temp[k++] = a[j++];
            }
        }
        // 把左边剩余的数移入数组
        while(i<=mid){
            temp[k++] = a[i++];
        }
        // 把右边边剩余的数移入数组
        while(j<=high){
            temp[k++] = a[j++];
        }
        // 把新数组中的数覆盖nums数组
        for(int x=0;x<temp.length;x++){
            a[x+low] = temp[x];
        }
    }

    public static int[] StringToInt(String[] arrs){
         int[] ints = new int[arrs.length];
         for(int i=0;i<arrs.length;i++){
            ints[i] = (int)(Double.parseDouble(arrs[i])*100);
         }
        return ints;
     }
}

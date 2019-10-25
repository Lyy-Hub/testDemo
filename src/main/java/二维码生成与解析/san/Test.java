package 二维码生成与解析.san;

/**
 * Created by liYueYang on 2019/10/25.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        // 存放在二维码中的内容
        String text = "神丹的小黄图";
        // 嵌入二维码的图片路径
        String imgPath = "G://shendan.png";
        // 生成的二维码的路径及名称
        String destPath = "G://beijing.png";
        //生成二维码
        QRCodeUtil.encode(text, imgPath, destPath, true);
        // 解析二维码
        String str = QRCodeUtil.decode(destPath);
        // 打印出解析出的内容
        System.out.println(str);
    }
}

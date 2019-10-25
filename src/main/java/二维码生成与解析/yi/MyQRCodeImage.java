package 二维码生成与解析.yi;

import jp.sourceforge.qrcode.data.QRCodeImage;

import java.awt.image.BufferedImage;

/**
 * Created by liYueYang on 2019/10/25.
 */
public class MyQRCodeImage implements QRCodeImage {

    BufferedImage bufferedImage;

    public MyQRCodeImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }

    //宽
    @Override
    public int getWidth() {
        return bufferedImage.getWidth();
    }

    //高
    @Override
    public int getHeight() {
        return bufferedImage.getHeight();
    }

    //像素还是颜色
    @Override
    public int getPixel(int i, int j) {
        return bufferedImage.getRGB(i, j);
    }
}

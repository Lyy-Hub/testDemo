package 图片处理;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;

/**
 * Created by liwj
 * date:2018/2/23
 * comment:
 */
 class ImageSplit  {

    /**
     * 切割图片
     *
     * @throws Exception
     */
    private static void splitImage() throws Exception {
        String originalImg = "D:\\---我的收藏---\\微信图片_20181016111943.jpg";
        File file = new File(originalImg);
        FileInputStream fis = new FileInputStream(file);
        BufferedImage image = ImageIO.read(fis);

        int rows = 2;
        int cols = 2;
        int chunks = rows * cols;

        int chunkWidth = image.getWidth() / cols;
        int chunkHeight = image.getHeight() / rows;

        int count = 0;
        BufferedImage[] imgs = new BufferedImage[chunks];
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                imgs[count] = new BufferedImage(chunkWidth, chunkHeight, image.getType());

                Graphics2D gr = imgs[count++].createGraphics();
                gr.drawImage(image, 0, 0, chunkWidth, chunkHeight,
                        chunkWidth * y, chunkHeight * x,
                        chunkWidth * y + chunkWidth, chunkHeight * x + chunkHeight, null);
                gr.dispose();
            }
        }
        for (int i = 0; i < imgs.length; i++) {
            ImageIO.write(imgs[i], "jpg", new File("D:\\---我的收藏---\\" + i + ".jpg"));
        }
    }

    /**
     * 合并图片
     *
     * @throws Exception
     */
    private static void mergeImage() throws Exception {
        int rows = 2;
        int cols = 2;
        int chunks = rows * cols;

        int chunkWidth, chunkHeight;
        int type;

        File[] imgFiles = new File[chunks];
        for (int i = 0; i < chunks; i++) {
            imgFiles[i] = new File("D:\\---我的收藏---\\" + i + ".jpg");
        }

        BufferedImage[] buffImages = new BufferedImage[chunks];
        for (int i = 0; i < chunks; i++) {
            buffImages[i] = ImageIO.read(imgFiles[i]);
        }
        type = buffImages[0].getType();
        chunkWidth = buffImages[0].getWidth();
        chunkHeight = buffImages[0].getHeight();

        BufferedImage finalImg = new BufferedImage(chunkWidth * cols, chunkHeight * rows, type);

        int num = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                finalImg.createGraphics().drawImage(buffImages[num], chunkWidth * j, chunkHeight * i, null);
                num++;
            }
        }

        ImageIO.write(finalImg, "jpeg", new File("D:\\---我的收藏---\\ 完整的.jpg"));
    }

    public static void main(String[] args) {
        try {
            splitImage();
            mergeImage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

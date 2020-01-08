package 图片处理;

import org.junit.jupiter.api.Test;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;

/**
 *BASE64
 */
public class Base64Test {

    @Test
    public void baseTest(){
        //加密
        String basestr = imageChangeBase64("D:/img/20191024/20191024171522182_藏A8A1X1.jpg");
        System.out.println(basestr);
//        String basestr = "/9j/4AAQSkZJRgABAgAAAQABAAD/2wBDAAgGBgcGBQgHBwcJCQgKDBQNDAsLDBkSEw8UHRofHh0a\n" +
//                "HBwgJC4nICIsIxwcKDcpLDAxNDQ0Hyc5PTgyPC4zNDL/2wBDAQkJCQwLDBgNDRgyIRwhMjIyMjIy\n" +
//                "MjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjL/wAARCAAoAGQDASIA\n" +
//                "AhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQA\n" +
//                "AAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3\n" +
//                "ODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWm\n" +
//                "p6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4+Tl5ufo6erx8vP09fb3+Pn6/8QAHwEA\n" +
//                "AwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSEx\n" +
//                "BhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElK\n" +
//                "U1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3\n" +
//                "uLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/9oADAMBAAIRAxEAPwDsvCOi\n" +
//                "+DX0LwtYXfhbS5r+80m3nad9PhbcTFklmIySSp9etdb/AMIJ4P8A+hU0P/wXQ/8AxNcj4U/4+/An\n" +
//                "/Yv2/wD6JavTq2rQUVG3VX/M1qwUVG3VX/M47WvD3gfQrNLq68I6Q6PIIwItNgJyQT3A9Ks3HhLw\n" +
//                "PaT2kM/hjQ0ku5TDAP7NiO9wjSEcLx8qMefT1xUPxF/5F+3/AOvpf/QHra8R6bNq3h+8tLVo0vCg\n" +
//                "ktJJCQsdwhDwucA8LIqNjBBxggjiicEqUZLd3/CwSglTjLq7/oc9pWieBdYv9Rs7fwhpKyWEvlSm\n" +
//                "TTYAGOWHy4B4+U9cUzxDpPgHw1axT3vhPR3819iRxadAXPGScEDgcZPuPWsrwJrkP9v63cXFrd2k\n" +
//                "eoXSbTcRhPIkZn2RSjOUclto7bhtzuZQ17xfcwS+PvDlpczR2sNrm7a4kcBfvZCnOMcxYzn+L251\n" +
//                "xFGMKzgtrL8kzIxP7b+Gf/Qk2n/gqtv8a6ax0LwLf+Hf7bi8IaStt5ckm19NgD4QkHjGP4T3q8Pi\n" +
//                "B4XIc/2oPlRnP7iToAScfLyeOAOSeBkmtbXf+Re1L/r1l/8AQDXLVfLFtKzM6snGEpLojjPCXgv4\n" +
//                "aXENw2kaFps0vy/aLe7IupYPvbdyuz+Xu5IxjIx1xx0f/CCeD/8AoVND/wDBdD/8TXMaVLeReHdP\n" +
//                "uW06eNbfzDZ6nYqbp4sudyTW4Ado2baNqb843ExlVZUi8WaivijTNQmSe80m7int1TSnW6txKQjh\n" +
//                "45Bs85QlvcZXYZUcOAGEkYOVGTnTjJ7tIjC1JVKEJy3aT+9FvTdN8CX2qz6XN4R0S3vI55IkB0+I\n" +
//                "pLtZsBX2Abii7tp54bG4ITW7/wAIJ4P/AOhU0P8A8F0P/wATWB4PGl+JpPEEkkEF/pl9LHMiTw7k\n" +
//                "lQs7qSjD6HkcV1+mafcad5sT6jPeWvHkLcgNJCOQV8wYLrjbgsC+dxZ2yMTh5udNSl5/mRgq0q1F\n" +
//                "Tnvd/g2j5k+Puk6bo3jqxt9L0+0sYG0yN2jtYViUt5soyQoAzgAZ9hRVz9o7/koen/8AYKj/APRs\n" +
//                "tFbHUei6Rp0OrQ+CbGdnWKXw/a7jGQDxEx7g+ldZ/wAK60j/AJ+b7/vtP/ia5/wp/wAffgT/ALF+\n" +
//                "3/8ARLV22s31xaar4ehgk2R3eoPDONoO9BazyAc9PmRTx6ema7qlepTjBQdtP1Z21K1SnGCi7afq\n" +
//                "zzfUNItdP8OrNLLIuq21ytlfxlh5Sy+VvJTjlWBRl5ztYBgGBA9I1u+uLCW2ntZPOZMtNYKoZ5oN\n" +
//                "yLJKgHzlowwbC53ZK7SzoV5f4m6RE9lHqUTSLcSPHBIoI2yKgkZM5GQV3yYwRnec5wuM8+OLTU9O\n" +
//                "Gm63o9++pwyBYvs0rRyNKF27g6bHiYsXUhc/KSOQxWtpUa2JoQnH3mm7/gY1as5wjz+eo/w5CuuP\n" +
//                "42WxNpcm4l8yzkeRvKZ90rRPvQ7gA21gyHIwCpBANT6LpeneJdcivNYlvLq6Fuk8CXJRVljBKMjx\n" +
//                "gfLLE4xKinaGZThd+xZPCcGo6FBcS6sk8F/rBVkv7iNGgWYlhGsiKysrszE4wqncqBg5C1l3yS6L\n" +
//                "4uPiG20RDLAGfULFApMEjK+ZkbZ/q3AZhKBknzFba25Rji5KWIlyvol9ySMDo/EXhOxlltxBpkAt\n" +
//                "Lg/Z5Ps9sFa0chtk42AMy7iqshyuCr/IEctS8I38998MtRSdt32WOeBGJJOwR7gDk9t2B7AVJJ8R\n" +
//                "Bq0T2fh7S7+fUJFKqWVQIs8BzywwCV64HqRWhofhWPwtoU729jHf6lPEiXiiUqLhVZjtUP8ALkLI\n" +
//                "4GdoY43FQcjkqRfs3GXUipHng490XfBX/Io2P/bT/wBGNV/UdM+332k3PneX/Z921zt258zMMsW3\n" +
//                "OeP9bnPP3cd8jiPD/iGXQLe4t5La6u9MilP78QyRPASB8rxyAFCcqdrbT824bgyk6k3xAhuF8nSt\n" +
//                "Ouri7fIRHUY6E5wpJOPTjjPIrzqWJp06ahN2aVrHl4bH0KNCNOq+WUUk1Z30007+Vin4C0lNMGu6\n" +
//                "NZ3M8cdrstYZ/lMihd6q3K7SwwDyuM9scVf1yLxjDod7YWiwal50TQx3sE/2W8hDfJvCEeW8ig79\n" +
//                "wkiDHgKmBm/4W046Na+RfTxNql4WuXUsDIVG0Hnq20sMnoC/vk9DW+Fi40kpb6/i7nXl9OVPDxU1\n" +
//                "Z6v723+p8ofHHU/7b8Q+HdW8nyft3h+2ufK3btm95G25wM4zjOBRR8dNM/sfxhp1iJvMjTTy0QC7\n" +
//                "RHG1zcMkajJwqKyoAOMKMADgFbnYe5+C/GnhW18C+Hre48S6NDPFplskkcl/ErIwiUEEFsgg8YqT\n" +
//                "xL4t8MahpUENr4n0OSRdQspiP7ShGEjuopHPLdlVj7445oooAuap4p8E6tYNaTeLdGQF0kSSPUoQ\n" +
//                "0ciOHRxkkZVlVsEEHGCCMiqaeLfDGsaHarrHifQ7XU4sMZbXUoQYZ1yplhJZvlPJAbOUba68stFF\n" +
//                "AGx/wnfg/wD6GvQ//BjD/wDFVn3XijwfLqMGo2vjHQ7a7TbHK326FlnhzkxuN4zjLFW6oxOMqzq5\n" +
//                "RQBof8J34P8A+hr0P/wYw/8AxVH/AAnfg/8A6GvQ/wDwYw//ABVFFAGXqXiHwbeXC39r4y0az1ON\n" +
//                "AsdwmpR7WAJIWWMOBKnLcNyN7FSjHdVPU/i14b07WIoBqljJac75I7iOXzF2hi6GN2xs5BSQIz5/\n" +
//                "d7mXY5RQBY1rWvA+s3mk3reLdDiu9LuxcQSjUIgcEFXQlXDbWU8jOCQu4MoKnQvvF3grULOS1m8W\n" +
//                "6Ukb4yYNYWFxgg8Ojhh07Hnp0oooA+cPjXLpcvjKz/sfWf7Us109Asn237X5R8yQlPMJLHru+ZiR\n" +
//                "uwCF2gFFFAH/2Q==";
//        //解密
//        base64ChangeImage(basestr,"D://2.png");
    }

    /**
     * 图片转BASE64
     * @param imagePath 路径
     * @return
     */
    public String imageChangeBase64(String imagePath){
        InputStream inputStream = null;
        byte[] data = null;
        try {
            inputStream = new FileInputStream(imagePath);
            data = new byte[inputStream.available()];
            inputStream.read(data);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 加密
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);
    }

    /**
     * BASE转图片
     * @param baseStr  base64字符串
     * @param imagePath 生成的图片
     * @return
     */
    public boolean base64ChangeImage(String baseStr,String imagePath){
        if (baseStr == null){
            return false;
        }
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            // 解密
            byte[] b = decoder.decodeBuffer(baseStr);
            // 处理数据
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }
            OutputStream out = new FileOutputStream(imagePath);
            out.write(b);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
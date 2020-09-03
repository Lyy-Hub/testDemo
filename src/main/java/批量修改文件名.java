import java.io.File;
import java.io.IOException;

/**
 * Created by liYueYang on 2020/6/24.
 */
public class 批量修改文件名 {

    static String dir = "D:\\BaiduNetdiskDownload\\周杰伦歌曲12张专辑\\歌曲";//文件所在路径，所有文件的根目录，记得修改为你电脑上的文件所在路径

    public static void main(String[] args) {
        recursiveTraversalFolder(dir);//递归遍历此路径下所有文件夹
    }

    /**
     * 递归遍历文件夹获取文件
     */
    public static void recursiveTraversalFolder(String path) {
        File folder = new File(path);
        if (folder.exists()) {
            File[] fileArr = folder.listFiles();
            if (null == fileArr || fileArr.length == 0) {
                System.out.println("文件夹是空的!");
                return;
            } else {
                File newDir = null;//文件所在文件夹路径+新文件名
                String newName = "";//新文件名
                String fileName = null;//旧文件名
                File parentPath = new File("");//文件所在父级路径
                for (File file : fileArr) {
                    if (file.isDirectory()) {//是文件夹，继续递归，如果需要重命名文件夹，这里可以做处理
                        recursiveTraversalFolder(file.getAbsolutePath());
                    } else {//是文件，判断是否需要重命名
                        fileName = file.getName();
                        parentPath = file.getParentFile();
                        newName = fileName.substring(0, fileName.length() - 4) + ".mp3";
                        newDir = new File(parentPath + "/" + newName);//文件所在文件夹路径+新文件名
                        file.renameTo(newDir);//重命名
                    }
                }
            }
        } else {
            System.out.println("文件不存在!");
        }
    }
}


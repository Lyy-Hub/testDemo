package Pdf2Word;

import org.pdfbox.pdmodel.PDDocument;
import org.pdfbox.util.PDFTextStripper;

import java.io.*;

/**
 * Created by liyueyang on 2019/4/4.
 */
public class PDFBox {
    public PDFBox() {
    }

    public static void pdfToDoc(String name1) throws IOException {
        PDDocument doc = PDDocument.load(name1);
        int pagenumber = doc.getNumberOfPages();
        name1 = name1.substring(0, name1.lastIndexOf("."));
        String fileName = name1 + ".docx";
        createFile(fileName);
        FileOutputStream fos = new FileOutputStream(fileName);
        Writer writer = new OutputStreamWriter(fos, "UTF-8");
        PDFTextStripper stripper = new PDFTextStripper();
        stripper.setSortByPosition(true);
        stripper.setStartPage(1);
        stripper.setEndPage(pagenumber);
        stripper.writeText(doc, writer);
        writer.close();
        doc.close();
        System.out.println("pdf转换word成功！");
    }

    private static void createDir(String destDirName) {
        File dir = new File(destDirName);
        if (dir.exists()) {
            System.out.println("创建目录失败，目标目录已存在！");
        }

        if (!destDirName.endsWith(File.separator)) {
            destDirName = destDirName + File.separator;
        }

        if (dir.mkdirs()) {
            System.out.println("创建目录成功！" + destDirName);
        } else {
            System.out.println("创建目录失败！");
        }

    }

    public static void createFile(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            System.out.println("目标文件已存在" + filePath);
        }

        if (filePath.endsWith(File.separator)) {
            System.out.println("目标文件不能为目录！");
        }

        if (!file.getParentFile().exists()) {
            System.out.println("目标文件所在目录不存在，准备创建它！");
            if (!file.getParentFile().mkdirs()) {
                System.out.println("创建目标文件所在的目录失败！");
            }
        }

        try {
            if (file.createNewFile()) {
                System.out.println("创建文件成功:" + filePath);
            } else {
                System.out.println("创建文件失败！");
            }
        } catch (IOException var3) {
            var3.printStackTrace();
            System.out.println("创建文件失败！" + var3.getMessage());
        }

    }

    public static void main(String[] args) throws Exception {
        String a = "D:\\测试2.pdf";
        pdfToDoc(a);
    }
}

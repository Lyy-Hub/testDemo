package Pdf2Word;

import java.io.IOException;
/**
 * Created by liyueyang on 2019/4/4.
 */
public class pdf2word {
    public static void main(String[] args) throws IOException {
        PDFBox pdfBox = new PDFBox();
        String pdfPath = "pdf2word.pdf";
        pdfBox.pdfToDoc(pdfPath);
    }
}

package Word2Pdf; /**
 * Created by liyueyang on 2018/11/30.
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;

public class FileConverter extends Thread{

    public static void main(String[] args) {
        new FileConverter("D:/测试.docx");
    }

    private static final int environment = 1;
    private String fileString;
    private String outputPath = "";
    private String fileName;
    private File pdfFile;
    private File swfFile;
    private File docFile;

    public FileConverter(String fileString) {
        ini(fileString);
    }

    /*
     * 重新设置 file @param fileString
     */
    public void setFile(String fileString) {
        ini(fileString);
    }

    /*
     * 初始化 @param fileString
     */
    private void ini(String fileString) {
        this.fileString = fileString;
        //判断文件类型
        String[] fileTypes = new String[] { "docx","doc","xls","xlsx","ppt","pptx","pdf" };
        String fileType = fileString.substring(fileString.lastIndexOf(".")+1, fileString.length());

        if(Arrays.asList(fileTypes).contains(fileType)){
            fileName = fileString.substring(0, fileString.lastIndexOf("."));
            docFile = new File(fileString);
            pdfFile = new File(fileName + ".pdf");
            swfFile = new File(fileName + ".swf");
            try {
                doc2pdf();
                //pdf2swf();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("不是OFFICE文件格式，不进行PDF转换");
        }
    }

    /*
     * 转为PDF @param file
     */
    private void doc2pdf() throws Exception {
        if (docFile.exists()) {
            if (!pdfFile.exists()) {
//                String OPENOFFICE_PATH = "C:\\Program Files (x86)\\OpenOffice 4\\program";
//                String OPENOFFICE_HOST_IP = "127.0.0.1";
//                int OPENOFFICE_PORT = 8100;
//                String command = "soffice -headless -accept=\"socket,host='"+OPENOFFICE_HOST_IP+"',port='"+OPENOFFICE_PORT+"'; urp; \" -nofirststartwizard";
//                File dir = new File(OPENOFFICE_PATH);//此处是指定路径
//                String[] cmd = new String[] { "cmd", "/c",command};// cmd[2]是要执行的dos命令
//                System.out.println("命令:"+cmd[2]);
//                Process process = Runtime.getRuntime().exec(command,null,dir);
                String OPENOFFICE_HOST_IP = "127.0.0.1";
                int OPENOFFICE_PORT = 8100;
                OpenOfficeConnection connection = new SocketOpenOfficeConnection(OPENOFFICE_HOST_IP, OPENOFFICE_PORT);
                try {
                    connection.connect();
                    DocumentConverter converter = new OpenOfficeDocumentConverter(connection);
                    converter.convert(docFile, pdfFile);
                    // close the connection
                    connection.disconnect();
                    //process.destroy();
                    System.out.println("****pdf转换成功，PDF输出：" + pdfFile.getPath());
                } catch (java.net.ConnectException e) {
                    // ToDo Auto-generated catch block
                    e.printStackTrace();
                    System.out.println("****swf转换异常，openoffice服务未启动！****");
                    throw e;
                } catch (com.artofsolving.jodconverter.openoffice.connection.OpenOfficeException e) {
                    e.printStackTrace();
                    System.out.println("****swf转换器异常，读取转换文件失败****");
                    throw e;
                } catch (Exception e) {
                    e.printStackTrace();
                    throw e;
                }
            } else {
                System.out.println("****已经转换为pdf，不需要再进行转化****");
            }
        } else {
            System.out.println("****swf转换器异常，需要转换的文档不存在，无法转换****");
        }
    }

    /*
     * 转换成swf
     */
    @SuppressWarnings("unused")
    private void pdf2swf() throws Exception {
        Runtime r = Runtime.getRuntime();
        if (!swfFile.exists()) {
            if (pdfFile.exists()) {
                if (environment == 1)// windows环境处理
                {
                    try {
                        // 这里根据SWFTools安装路径需要进行相应更改
                        Process p = r.exec("E:/SWFTools/install/pdf2swf.exe"+" "+ pdfFile.getPath() + " -o " + swfFile.getPath() + " -T 9");
                        System.out.print(loadStream(p.getInputStream()));
                        System.err.print(loadStream(p.getErrorStream()));
                        System.out.print(loadStream(p.getInputStream()));
                        System.err.println("****swf转换成功，文件输出：" + swfFile.getPath() + "****");
                        if (pdfFile.exists()) {
                            pdfFile.delete();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        throw e;
                    }
                } else if (environment == 2)// linux环境处理
                {
                    try {
                        Process p = r.exec("pdf2swf " + pdfFile.getPath() + " -o " + swfFile.getPath() + " -T 9");
                        System.out.print(loadStream(p.getInputStream()));
                        System.err.print(loadStream(p.getErrorStream()));
                        System.err.println("****swf转换成功，文件输出：" + swfFile.getPath() + "****");
                        if (pdfFile.exists()) {
                            pdfFile.delete();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        throw e;
                    }
                }
            } else {
                System.out.println("****pdf不存在，无法转换****");
            }
        } else {
            System.out.println("****swf已存在不需要转换****");
        }
    }

    static String loadStream(InputStream in) throws IOException {
        int ptr = 0;
        // 把InputStream字节流 替换为BufferedReader字符流
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder buffer = new StringBuilder();
        while ((ptr = reader.read()) != -1) {
            buffer.append((char) ptr);
        }
        return buffer.toString();
    }

    /*
     * 转换主方法
     */
    @SuppressWarnings("unused")
    public void run() {
        try{
            if(null == swfFile){
                throw new Exception("文件为空");
            }

            if (swfFile.exists()) {
                System.out.println("****swf转换器开始工作，该文件已经转换为swf****");
//				return true;
            }
            if (environment == 1) {
                System.out.println("****swf转换器开始工作，当前设置运行环境windows****");
            } else {
                System.out.println("****swf转换器开始工作，当前设置运行环境linux****");
            }

            doc2pdf();
            pdf2swf();

//			if (swfFile.exists()) {
//				return true;
//			} else {
//				return false;
//			}
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    /*
     * 返回文件路径 @param s
     */
    public String getswfPath() {
        if (swfFile.exists()) {
            String tempString = swfFile.getPath();
            tempString = tempString.replaceAll("\\\\", "/");
            return tempString;
        } else {
            return "";
        }
    }

    /*
     * 设置输出路径
     */
    public void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
        if (!outputPath.equals("")) {
            String realName = fileName.substring(fileName.lastIndexOf("/"), fileName.lastIndexOf("."));
            if (outputPath.charAt(outputPath.length()) == '/') {
                swfFile = new File(outputPath + realName + ".swf");
            } else {
                swfFile = new File(outputPath + realName + ".swf");
            }
        }
    }
}


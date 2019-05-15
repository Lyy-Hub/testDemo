import mypackage.RandomFontsWebService;
import mypackage.RandomFontsWebServiceSoap;

import java.util.List;
import java.util.regex.Pattern;

public class testq {
    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                while (true){
                    //System.out.println(name("李"));
                    String chepaihao = carNo();
                    if(chepaihao != ""){
                        System.out.println(carNo());
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }.start();
    }
    public static String name(String xingshi){
        RandomFontsWebService randomFontsWebService = new RandomFontsWebService();
        RandomFontsWebServiceSoap randomFontsWebServiceSoap = randomFontsWebService.getRandomFontsWebServiceSoap();
        List yi = randomFontsWebServiceSoap.getChineseFonts(1).getString();
        String q = (String) yi.get(0);
        List er = randomFontsWebServiceSoap.getChineseFonts(1).getString();
        String w = (String) er.get(0);
        return xingshi+q+w;
    }
    public static String carNo(){
        RandomFontsWebService randomFontsWebService = new RandomFontsWebService();
        RandomFontsWebServiceSoap randomFontsWebServiceSoap = randomFontsWebService.getRandomFontsWebServiceSoap();
        List yi = randomFontsWebServiceSoap.getCharFonts(6).getString();
        String qwe="";
        for(int i = 0;i<yi.size();i++){
            Pattern pattern = Pattern.compile("[0-9]*");
            String ww = yi.get(0).toString();
            if(pattern.matcher(ww).matches()){
                break;
            }
            qwe+=yi.get(i);
        }
        if("".equals(qwe)){
            return "";
        }
        List er = randomFontsWebServiceSoap.getChineseFonts(1).getString();
        String w = (String) er.get(0);
        return w+qwe;
    }
}

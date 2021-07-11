package dom4jxml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liyueyang on 2019/4/8.
 */
public class Test {
    public static void main(String[] args) throws DocumentException {
        String[] string={"aaa","bbb","ccc","ddd"};
        List<String> list = new ArrayList<String>();
        for(String s:string){
            list.add(s);
        }
        String result = "";
        Document document = DocumentHelper.createDocument();//DocumentHelper创建document对象
        Element root = document.addElement("XZLGInfoParmOut");//创建根节点
        Element studentsElem = root.addElement("SuccInfo");
        for(int i=0;i<list.size();i++){//遍历集合 创建子节点
            Element wybs = studentsElem.addElement("WYBS");
            wybs.addText(list.get(i));
        }
        result = document.asXML();
        System.out.println(result);

        Document dom = DocumentHelper.parseText(result);
        Element a = dom.getRootElement();
        Element b = a.element("SuccInfo");
        Element c = b.element("WYBS");
        String d = c.getTextTrim();
        System.out.println(d);

            char myChar = 'g';
            String myStr = Character.toString(myChar);
            System.out.println("String is: "+myStr);
            myStr = String.valueOf(myChar);
            System.out.println("String is: "+myStr);

    }
}

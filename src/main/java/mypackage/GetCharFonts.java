
package mypackage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="byFontsLength" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "byFontsLength"
})
@XmlRootElement(name = "getCharFonts")
public class GetCharFonts {

    protected int byFontsLength;

    /**
     * ��ȡbyFontsLength���Ե�ֵ��
     * 
     */
    public int getByFontsLength() {
        return byFontsLength;
    }

    /**
     * ����byFontsLength���Ե�ֵ��
     * 
     */
    public void setByFontsLength(int value) {
        this.byFontsLength = value;
    }

}

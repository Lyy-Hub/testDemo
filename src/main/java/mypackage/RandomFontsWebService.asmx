<?xml version="1.0" encoding="utf-8"?>
<wsdl:definitions xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:tm="http://microsoft.com/wsdl/mime/textMatching/" xmlns:soapenc="http://schemas.xmlsoap.org/soap/encoding/" xmlns:mime="http://schemas.xmlsoap.org/wsdl/mime/" xmlns:tns="http://WebXml.com.cn/" xmlns:s="http://www.w3.org/2001/XMLSchema" xmlns:soap12="http://schemas.xmlsoap.org/wsdl/soap12/" xmlns:http="http://schemas.xmlsoap.org/wsdl/http/" targetNamespace="http://WebXml.com.cn/" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">
  <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">&lt;a href="http://www.webxml.com.cn/" target="_blank"&gt;WebXml.com.cn&lt;/a&gt; &lt;strong&gt;随机英文、数字和中文简体字 WEB 服务&lt;/strong&gt; 可用于验证码[&lt;a href="http://www.webxml.com.cn/ValidateCode/ChineseValidateCode.aspx" target="_blank"&gt;演示1&lt;/a&gt;] [&lt;a href="http://www.webxml.com.cn/ValidateCode/EnglishValidateCode.aspx" target="_blank"&gt;演示2&lt;/a&gt;]及其他方面，这里支持最多不超过8个随机中文简体字，10个随机英文、数字输出（一般也够了:P），如需要更多输出请&lt;a href="http://www.webxml.com.cn/zh_cn/contact_us.aspx" target="_blank"&gt;联系我们&lt;/a&gt;，欢迎技术交流。 QQ：8409035&lt;br /&gt;&lt;strong&gt;使用本站 WEB 服务请注明或链接本站：http://www.webxml.com.cn/ 感谢大家的支持&lt;/strong&gt;！&lt;br /&gt;&lt;br /&gt;&amp;nbsp;</wsdl:documentation>
  <wsdl:types>
    <s:schema elementFormDefault="qualified" targetNamespace="http://WebXml.com.cn/">
      <s:element name="getChineseFonts">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="byFontsLength" type="s:int" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="getChineseFontsResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="getChineseFontsResult" type="tns:ArrayOfString" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:complexType name="ArrayOfString">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="unbounded" name="string" nillable="true" type="s:string" />
        </s:sequence>
      </s:complexType>
      <s:element name="getCharFonts">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="1" maxOccurs="1" name="byFontsLength" type="s:int" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="getCharFontsResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="getCharFontsResult" type="tns:ArrayOfString" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="ArrayOfString" nillable="true" type="tns:ArrayOfString" />
    </s:schema>
  </wsdl:types>
  <wsdl:message name="getChineseFontsSoapIn">
    <wsdl:part name="parameters" element="tns:getChineseFonts" />
  </wsdl:message>
  <wsdl:message name="getChineseFontsSoapOut">
    <wsdl:part name="parameters" element="tns:getChineseFontsResponse" />
  </wsdl:message>
  <wsdl:message name="getCharFontsSoapIn">
    <wsdl:part name="parameters" element="tns:getCharFonts" />
  </wsdl:message>
  <wsdl:message name="getCharFontsSoapOut">
    <wsdl:part name="parameters" element="tns:getCharFontsResponse" />
  </wsdl:message>
  <wsdl:message name="getChineseFontsHttpGetIn">
    <wsdl:part name="byFontsLength" type="s:string" />
  </wsdl:message>
  <wsdl:message name="getChineseFontsHttpGetOut">
    <wsdl:part name="Body" element="tns:ArrayOfString" />
  </wsdl:message>
  <wsdl:message name="getCharFontsHttpGetIn">
    <wsdl:part name="byFontsLength" type="s:string" />
  </wsdl:message>
  <wsdl:message name="getCharFontsHttpGetOut">
    <wsdl:part name="Body" element="tns:ArrayOfString" />
  </wsdl:message>
  <wsdl:message name="getChineseFontsHttpPostIn">
    <wsdl:part name="byFontsLength" type="s:string" />
  </wsdl:message>
  <wsdl:message name="getChineseFontsHttpPostOut">
    <wsdl:part name="Body" element="tns:ArrayOfString" />
  </wsdl:message>
  <wsdl:message name="getCharFontsHttpPostIn">
    <wsdl:part name="byFontsLength" type="s:string" />
  </wsdl:message>
  <wsdl:message name="getCharFontsHttpPostOut">
    <wsdl:part name="Body" element="tns:ArrayOfString" />
  </wsdl:message>
  <wsdl:portType name="RandomFontsWebServiceSoap">
    <wsdl:operation name="getChineseFonts">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">&lt;br /&gt;&lt;h3&gt;获得随机中文简体字Web Services&lt;/h3&gt;&lt;p&gt;输入参数：byFontsLength = 输出中文字的数量（Integer）；返回数据：一个一维字符串数组 String()，内容为随机中文简体字。这里支持最多不超过8个中文简体字输出，如需要更多输出请&lt;a href="http://www.webxml.com.cn/zh_cn/contact_us.aspx" target="_blank"&gt;联系我们&lt;/a&gt;。</wsdl:documentation>
      <wsdl:input message="tns:getChineseFontsSoapIn" />
      <wsdl:output message="tns:getChineseFontsSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="getCharFonts">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">&lt;br /&gt;&lt;h3&gt;获得随机英文、数字Web Services&lt;/h3&gt;&lt;p&gt;输入参数：byFontsLength = 输出字的数量（Integer）；返回数据：一个一维字符串数组 String()，内容为随机英文、数字。为了避免混淆只输出，只随机产生 1,2,3,4,5,6,7,8,9,A,C,D,E,F,H,K,L,M,N,P,R,S,T,W,X,Y,Z，这里支持最多不超过10个输出，如需要更多输出请&lt;a href="http://www.webxml.com.cn/zh_cn/contact_us.aspx" target="_blank"&gt;联系我们&lt;/a&gt;。</wsdl:documentation>
      <wsdl:input message="tns:getCharFontsSoapIn" />
      <wsdl:output message="tns:getCharFontsSoapOut" />
    </wsdl:operation>
  </wsdl:portType>
  <wsdl:portType name="RandomFontsWebServiceHttpGet">
    <wsdl:operation name="getChineseFonts">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">&lt;br /&gt;&lt;h3&gt;获得随机中文简体字Web Services&lt;/h3&gt;&lt;p&gt;输入参数：byFontsLength = 输出中文字的数量（Integer）；返回数据：一个一维字符串数组 String()，内容为随机中文简体字。这里支持最多不超过8个中文简体字输出，如需要更多输出请&lt;a href="http://www.webxml.com.cn/zh_cn/contact_us.aspx" target="_blank"&gt;联系我们&lt;/a&gt;。</wsdl:documentation>
      <wsdl:input message="tns:getChineseFontsHttpGetIn" />
      <wsdl:output message="tns:getChineseFontsHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="getCharFonts">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">&lt;br /&gt;&lt;h3&gt;获得随机英文、数字Web Services&lt;/h3&gt;&lt;p&gt;输入参数：byFontsLength = 输出字的数量（Integer）；返回数据：一个一维字符串数组 String()，内容为随机英文、数字。为了避免混淆只输出，只随机产生 1,2,3,4,5,6,7,8,9,A,C,D,E,F,H,K,L,M,N,P,R,S,T,W,X,Y,Z，这里支持最多不超过10个输出，如需要更多输出请&lt;a href="http://www.webxml.com.cn/zh_cn/contact_us.aspx" target="_blank"&gt;联系我们&lt;/a&gt;。</wsdl:documentation>
      <wsdl:input message="tns:getCharFontsHttpGetIn" />
      <wsdl:output message="tns:getCharFontsHttpGetOut" />
    </wsdl:operation>
  </wsdl:portType>
  <wsdl:portType name="RandomFontsWebServiceHttpPost">
    <wsdl:operation name="getChineseFonts">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">&lt;br /&gt;&lt;h3&gt;获得随机中文简体字Web Services&lt;/h3&gt;&lt;p&gt;输入参数：byFontsLength = 输出中文字的数量（Integer）；返回数据：一个一维字符串数组 String()，内容为随机中文简体字。这里支持最多不超过8个中文简体字输出，如需要更多输出请&lt;a href="http://www.webxml.com.cn/zh_cn/contact_us.aspx" target="_blank"&gt;联系我们&lt;/a&gt;。</wsdl:documentation>
      <wsdl:input message="tns:getChineseFontsHttpPostIn" />
      <wsdl:output message="tns:getChineseFontsHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="getCharFonts">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">&lt;br /&gt;&lt;h3&gt;获得随机英文、数字Web Services&lt;/h3&gt;&lt;p&gt;输入参数：byFontsLength = 输出字的数量（Integer）；返回数据：一个一维字符串数组 String()，内容为随机英文、数字。为了避免混淆只输出，只随机产生 1,2,3,4,5,6,7,8,9,A,C,D,E,F,H,K,L,M,N,P,R,S,T,W,X,Y,Z，这里支持最多不超过10个输出，如需要更多输出请&lt;a href="http://www.webxml.com.cn/zh_cn/contact_us.aspx" target="_blank"&gt;联系我们&lt;/a&gt;。</wsdl:documentation>
      <wsdl:input message="tns:getCharFontsHttpPostIn" />
      <wsdl:output message="tns:getCharFontsHttpPostOut" />
    </wsdl:operation>
  </wsdl:portType>
  <wsdl:binding name="RandomFontsWebServiceSoap" type="tns:RandomFontsWebServiceSoap">
    <soap:binding transport="http://schemas.xmlsoap.org/soap/http" />
    <wsdl:operation name="getChineseFonts">
      <soap:operation soapAction="http://WebXml.com.cn/getChineseFonts" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="getCharFonts">
      <soap:operation soapAction="http://WebXml.com.cn/getCharFonts" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:binding name="RandomFontsWebServiceSoap12" type="tns:RandomFontsWebServiceSoap">
    <soap12:binding transport="http://schemas.xmlsoap.org/soap/http" />
    <wsdl:operation name="getChineseFonts">
      <soap12:operation soapAction="http://WebXml.com.cn/getChineseFonts" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="getCharFonts">
      <soap12:operation soapAction="http://WebXml.com.cn/getCharFonts" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:binding name="RandomFontsWebServiceHttpGet" type="tns:RandomFontsWebServiceHttpGet">
    <http:binding verb="GET" />
    <wsdl:operation name="getChineseFonts">
      <http:operation location="/getChineseFonts" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="getCharFonts">
      <http:operation location="/getCharFonts" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:binding name="RandomFontsWebServiceHttpPost" type="tns:RandomFontsWebServiceHttpPost">
    <http:binding verb="POST" />
    <wsdl:operation name="getChineseFonts">
      <http:operation location="/getChineseFonts" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="getCharFonts">
      <http:operation location="/getCharFonts" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:service name="RandomFontsWebService">
    <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">&lt;a href="http://www.webxml.com.cn/" target="_blank"&gt;WebXml.com.cn&lt;/a&gt; &lt;strong&gt;随机英文、数字和中文简体字 WEB 服务&lt;/strong&gt; 可用于验证码[&lt;a href="http://www.webxml.com.cn/ValidateCode/ChineseValidateCode.aspx" target="_blank"&gt;演示1&lt;/a&gt;] [&lt;a href="http://www.webxml.com.cn/ValidateCode/EnglishValidateCode.aspx" target="_blank"&gt;演示2&lt;/a&gt;]及其他方面，这里支持最多不超过8个随机中文简体字，10个随机英文、数字输出（一般也够了:P），如需要更多输出请&lt;a href="http://www.webxml.com.cn/zh_cn/contact_us.aspx" target="_blank"&gt;联系我们&lt;/a&gt;，欢迎技术交流。 QQ：8409035&lt;br /&gt;&lt;strong&gt;使用本站 WEB 服务请注明或链接本站：http://www.webxml.com.cn/ 感谢大家的支持&lt;/strong&gt;！&lt;br /&gt;&lt;br /&gt;&amp;nbsp;</wsdl:documentation>
    <wsdl:port name="RandomFontsWebServiceSoap" binding="tns:RandomFontsWebServiceSoap">
      <soap:address location="http://www.webxml.com.cn/WebServices/RandomFontsWebService.asmx" />
    </wsdl:port>
    <wsdl:port name="RandomFontsWebServiceSoap12" binding="tns:RandomFontsWebServiceSoap12">
      <soap12:address location="http://www.webxml.com.cn/WebServices/RandomFontsWebService.asmx" />
    </wsdl:port>
    <wsdl:port name="RandomFontsWebServiceHttpGet" binding="tns:RandomFontsWebServiceHttpGet">
      <http:address location="http://www.webxml.com.cn/WebServices/RandomFontsWebService.asmx" />
    </wsdl:port>
    <wsdl:port name="RandomFontsWebServiceHttpPost" binding="tns:RandomFontsWebServiceHttpPost">
      <http:address location="http://www.webxml.com.cn/WebServices/RandomFontsWebService.asmx" />
    </wsdl:port>
  </wsdl:service>
</wsdl:definitions>
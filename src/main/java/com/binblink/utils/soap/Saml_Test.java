package com.binblink.utils.soap;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;


import javax.xml.soap.*;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;

/**
 * @Description
 * @Author binblink
 * @Date 2020/12/24 11:25
 */
public class Saml_Test {

    private static final String soapRequestData = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
            "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
            "  <soap:Body>\n" +
            "    <getSupportCityDataset xmlns=\"http://WebXml.com.cn/\">\n" +
            "      <theRegionCode></theRegionCode>\n" +
            "    </getSupportCityDataset>\n" +
            "  </soap:Body>\n" +
            "</soap:Envelope>";

    public static void main(String[] args) {
        try {
            String data = createSOAPXmlRequest("");
            System.out.println(data);
            PostMethod postmethod = new PostMethod(
                    "http://ws.webxml.com.cn/WebServices/WeatherWS.asmx");
            byte[] b = soapRequestData.getBytes("UTF-8");
            InputStream is = new ByteArrayInputStream(b, 0, b.length);
            RequestEntity re = new InputStreamRequestEntity(is, b.length,
                    "text/xml; SOAPAction=\"http://WebXml.com.cn/getSupportCityDataset\"");
            postmethod.setRequestEntity(re);
            HttpClient httpClient = new HttpClient();
            int statusCode = httpClient.executeMethod(postmethod);
            System.out.println("statuscode=" + statusCode);
            String soapResponseData = postmethod.getResponseBodyAsString();
            System.out.println(soapResponseData);
//            invokeMethod("");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static String createSOAPXmlRequest(String json){

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>")
                .append("<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">")
                .append("<soap:Body>\n" +
                        "   <getSupportCityDataset xmlns=\"http://WebXml.com.cn/\">\n" +
                        "      <theRegionCode>31125</theRegionCode>\n" +
                        "    </getSupportCityDataset>" +
                        "  </soap:Body>\n" +
                        "</soap:Envelope>");


        return stringBuffer.toString();
    }


    /**
     * soap请求
     *
     * @return
     * @throws Exception
     */
    public static String invokeMethod(Object data) throws Exception {
        // 创建连接
        SOAPConnectionFactory soapConnFactory = SOAPConnectionFactory.newInstance();
        SOAPConnection soapConn = soapConnFactory.createConnection();
        // 创建消息对象
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        // 创建soap消息主体
        MimeHeaders mimeHeaders = soapMessage.getMimeHeaders();
        mimeHeaders.setHeader("Content-Type", "text/xml; charset=utf-8");
        SOAPPart soapPart = soapMessage.getSOAPPart();
        SOAPEnvelope soapEnvelope = soapPart.getEnvelope();
        SOAPBody body = soapEnvelope.getBody();
        // 根据要传给mule的参数，创建消息body内容
        SOAPElement bodyElement =body.addChildElement(soapEnvelope.createName("", "","http://WebXml.com.cn"));

        soapMessage.saveChanges();

        //     soapMessage = saveSoapChage(data, soapEnvelope, body, soapMessage);
        /*
         * 实际的消息是使用 call()方法发送的，该方法接收消息本身和目的地作为参数，并返回第二个 SOAPMessage 作为响应。
         * call方法的message对象为发送的soap报文，url为mule配置的inbound端口地址。
         */
        URL url = new URL("http://ws.webxml.com.cn/WebServices/WeatherWS.asmx/getSupportCityDataset");
        // 响应消息
        SOAPMessage reply = soapConn.call(soapMessage, url);
        // 创建soap消息转换对象
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        // 提取消息内容
        Source sourceContent = reply.getSOAPPart().getContent();
        //输出流
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        StreamResult result = new StreamResult(out);
        //sourceContent实现此接口的对象包含充当源输入（XML 源或转换指令）所需的信息
        //result充当转换结果的持有者，可以为 XML、纯文本、HTML 或某些其他格式的标记
        transformer.transform(sourceContent, result);
        //返回结果
        String xmlData = new String(out.toByteArray());
        // xml解析
//        xmlData = parserXml(data, xmlData);
        //输出到控制台
        System.out.println(xmlData);
        //关闭连接
        soapConn.close();
        return xmlData;
    }

}

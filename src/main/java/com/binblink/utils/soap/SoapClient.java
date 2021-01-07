package com.binblink.utils.soap;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import static com.binblink.utils.soap.SoapConstants.*;
/**
 * @Description
 * @Author binblink
 * @Date 2020/12/24 13:06
 */
public class SoapClient {

    private static final String soapRequestData = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
            "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
            "  <soap:Body>\n" +
            "    <getSupportCityDataset xmlns=\"http://WebXml.com.cn/\">\n" +
            "      <theRegionCode>32343</theRegionCode>\n" +
            "    </getSupportCityDataset>\n" +
            "  </soap:Body>\n" +
            "</soap:Envelope>";

    private static  HttpClient client = new DefaultHttpClient();

    private static HttpPost generatePost(String soapAction, String requestEnvelope) throws UnsupportedEncodingException {


            HttpPost post = new HttpPost("http://ws.webxml.com.cn/WebServices/WeatherWS.asmx");
            StringEntity contentEntity = new StringEntity(requestEnvelope);
            post.setEntity(contentEntity);
            if (requestEnvelope.contains(SoapConstants.SOAP_1_1_NAMESPACE)) {
                soapAction = soapAction != null ? "\"" + soapAction + "\"" : "";
                post.addHeader(PROP_SOAP_ACTION_11, soapAction);
                post.addHeader(PROP_CONTENT_TYPE, MIMETYPE_TEXT_XML);
                client.getParams().setParameter(PROP_CONTENT_TYPE, MIMETYPE_TEXT_XML);
            } else if (requestEnvelope.contains(SOAP_1_2_NAMESPACE)) {
                String contentType = MIMETYPE_APPLICATION_XML;
                if (soapAction != null) {
                    contentType = contentType + PROP_DELIMITER + PROP_SOAP_ACTION_12 + "\"" + soapAction + "\"";
                }
                post.addHeader(PROP_CONTENT_TYPE, contentType);
            }
            return post;
    }

    public static void main(String[] args) throws IOException {
        String soapaction = "http://WebXml.com.cn/getSupportCityDataset";

        HttpPost post = generatePost(soapaction,soapRequestData);

        HttpResponse response = client.execute(post);
        StatusLine statusLine = response.getStatusLine();
        HttpEntity entity = response.getEntity();
        System.out.println(EntityUtils.toString(entity));

    }
}

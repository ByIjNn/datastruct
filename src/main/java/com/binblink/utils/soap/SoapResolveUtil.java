package com.binblink.utils.soap;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import okhttp3.*;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import java.io.IOException;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @Description 解析 SOAP 成 json
 * @Author binblink
 * @Date 2020/12/23 18:01
 */
public class SoapResolveUtil {

    private static final long TIMEOUT = 15;
    public static List<Element> pareentList = new ArrayList<>(1);
    public static List<Element> dataList = new ArrayList<>(64);
     /**
      * @Description  post 请求
      * @params  url 请求地址 如http://WebXml.com.cn//WebServices/WeatherWS.asmx 一般带.asmx 后缀
      * @params  soapRequestBody 请求参数 如
      *               <getSupportCityDataset xmlns="http://WebXml.com.cn/">
      *                      <theRegionCode>31125</theRegionCode>
      *                </getSupportCityDataset>
      * @return
      * @author binblink
      * @Datetime  2020/12/23 19:10
      */
    public static Object resolve(String url,String soapRequestBody) throws IOException {

        String xml = createSOAPXmlRequestBody(soapRequestBody);
        RequestBody body  = RequestBody.create(MediaType.parse("text/xml"), xml);

        Request request = new Request.Builder()
//                .header("SOAPAction","http://WebXml.com.cn/getSupportCityDataset")
                .url(url).post(body).build();

        return resolve(request);
    }


     /**
      * @Description  解析
      * @params 请求参数
      * @return
      * @author binblink
      * @Datetime  2020/12/23 20:49
      */
    private static Object resolve(Request request)  {
        String result = "";
        try {
            OkHttpClient client = getHttpClient();
            Call call = client.newCall(request);
            Response response = call.execute();

            ResponseBody responseBody = response.body();

            result =  responseBody.string();
            System.out.println(result);
            JSONArray array = xmlToJson(result);

            System.out.println(array.toJSONString());

        }catch (IOException e){
            e.printStackTrace();
        }

        return result;
    }




    public static JSONArray xmlToJson(String xml)  {
        Document doc = null;//报文转成doc对象
        try {
            doc = DocumentHelper.parseText(xml);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        Element root = doc.getRootElement();//获取根元素，准备递归解析这个XML树
        JSONArray jsonArray = new JSONArray();

        findDataParent(root);
        System.out.println(pareentList.get(0).getName()+pareentList.size());
        Element parent = null;

        if(pareentList.size() != 0){
            parent = pareentList.get(0);
        }

        if(Objects.nonNull(parent)){
            //查找所有和parent同名的元素
            findValueElement(parent.getName(),root);
        }

        System.out.println(dataList.size());
        toJson(jsonArray);
        return jsonArray;
    }

    private static void toJson(JSONArray jsonArray) {

        if(dataList.size()>0){
            for(Element el : dataList){
                JSONObject jsonObject = new JSONObject();
                formToJson(el,jsonObject);
                jsonArray.add(jsonObject);
            }
        }
    }

    private static void formToJson(Element el,JSONObject jsonObject) {
        List<Element> children = el.elements();
        for(Element element : children){
            String v = element.getTextTrim();
            jsonObject.put(element.getName(),v);
        }
    }

    /**
     * 找出第一个有值的元素的 父元素
     * @param root
     */
    public static void findDataParent(Element root){

        if(!root.getTextTrim().equals("")){
            if(pareentList.size()<1){
                pareentList.add(root);
            }
            return;
        }
        List<Element> elements = root.elements();
        for(Element el : elements){
            if(!el.getTextTrim().equals("")){
                Element parent = el.getParent();
                if(!Objects.isNull(parent)){
                    if(pareentList.size()<1){
                        pareentList.add(parent);
                    }
                }else {
                    if(pareentList.size()<1){
                        pareentList.add(el);
                    }
                }
                return;
            }
        }
        for(Element el : elements){
            findDataParent(el);
        }
    }

    //查找同名元素
    public static void findValueElement(String name,Element root){

        List<Element> elements = root.elements();
        for(Element el : elements){
            if(el.getName().equals(name)){
                dataList.add(el);
            }
        }
        for(Element el : elements){
            findValueElement(name,el);
        }
    }

    /**
      * @Description  获取一个client
      * @return OkHttpClient
      * @author binblink
      * @Datetime  2020/12/23 20:49
      */
    private static OkHttpClient getHttpClient(){
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                .build();
        return client;
    }

    private static String createSOAPXmlRequestBody(String soapRequestBody){

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>")
                .append("<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">")
                .append("<soap:Body>\n")
                .append(soapRequestBody)
                .append("</soap:Body>\n")
                .append("</soap:Envelope>");
        return stringBuffer.toString();
    }

    public static void main(String[] args) throws IOException {

        String body =
                "    <getSupportCityDataset xmlns=\"http://WebXml.com.cn/\">\n" +
                "      <theRegionCode>31125</theRegionCode>\n" +
                "    </getSupportCityDataset>\n";


        String body2 =
                "    <getMobileCodeInfo xmlns=\"http://WebXml.com.cn/\">\n" +
                "      <mobileCode>13768401210</mobileCode>\n" +
                "    </getMobileCodeInfo>\n";

        String body3 = "<getFundCodeNameDataSet xmlns=\"http://WebXml.com.cn/\" />";

        String url = "http://ws.webxml.com.cn/WebServices/WeatherWS.asmx";
        String url2 = "http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx";
        String url3 = "http://WebXml.com.cn/WebServices/ChinaOpenFundWS.asmx";


        resolve(url2,body2);

    }


}

package com.binblink.utils.soap;

import cn.com.webxml.ArrayOfString;
import cn.com.webxml.MobileCodeWS;
import cn.com.webxml.MobileCodeWSSoap;

import java.util.List;

/**
 * @Description webservice 客户端调用
 * @Author binblink
 * @Date 2020/12/24 14:18
 */
public class Test2 {



    public static void main(String[] args) {
        String theCityCode = "长沙";
        MobileCodeWS mobileCodeWS = new MobileCodeWS();
        MobileCodeWSSoap mobileCodeWSSoap = mobileCodeWS.getMobileCodeWSSoap();
        //后面的userID，若有的网站已经付过钱，则可直接访问
        //调用webservice提供的getWeather方法获取上海的天气预报情况
        ArrayOfString weather = mobileCodeWSSoap.getDatabaseInfo();
        String mesg = mobileCodeWSSoap.getMobileCodeInfo("18807734708","");

        List<String> string = weather.getString();

        System.out.println(mesg);
        //遍历天气预报信息
        for (String str : string) {
            System.out.println(str);
            System.out.println("===========");
        }
    }
}

package com.binblink.utils;

import com.alibaba.fastjson.JSONObject;
import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author binblink
 * @Date 2020/12/30 10:21
 */
public class HttpClient {

    private static final long TIMEOUT = 15;


    public static void main(String[] args) throws IOException {

        String url = "";
        JSONObject object = new JSONObject();
        JSONObject bodyObj = new JSONObject();


        RequestBody body  = RequestBody.create(MediaType.parse("application/json; charset=UTF-8"), object.toJSONString());

        Request request = new Request.Builder()
                .url(url).post(body).build();

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();

        ResponseBody responseBody = response.body();
        System.out.println( responseBody.string());
    }
}

package com.xiayule.service;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Created by tan on 14-6-26.
 */
public class HttpService {
    public static String get(String url) {
        try {
            // 根据内容来源地址创建一个Http请求
            HttpGet request = new HttpGet(url);

            DefaultHttpClient client = new DefaultHttpClient();



            HttpResponse httpResponse = client.execute(request); // 发送请求并获取反馈
            // 解析返回的内容
            if (httpResponse.getStatusLine().getStatusCode() != 404) {
                String result = EntityUtils.toString(httpResponse.getEntity());

                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

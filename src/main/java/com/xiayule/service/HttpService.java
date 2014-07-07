package com.xiayule.service;

import java.io.*;

/**
 * Created by tan on 14-6-26.
 */
public class HttpService {
/*    public static String get(String url) {
        try {
            // 根据内容来源地址创建一个Http请求
            HttpGet request = new HttpGet(url);

            DefaultHttpClient client = new DefaultHttpClient();


            HttpResponse httpResponse = client.execute(request); // 发送请求并获取反馈
            // 解析返回的内容
            if (httpResponse.getStatusLine().getStatusCode() != 404) {
//                String result = EntityUtils.toString(httpResponse.getEntity());

                // 获取数据，为了和写统一，防止乱码
                InputStream in = httpResponse.getEntity().getContent();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len = -1;
                while ((len = in.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, len);
                }

                outputStream.close();
                in.close();

                // 解析内容
                String result = new String(outputStream.toByteArray());

                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }*/
}

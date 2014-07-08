package com.xiayule.service.impl;

import com.xiayule.service.FileService;

import java.io.*;


/**
 * Created by tan on 14-7-7.
 */
public class SaeFileServiceImpl implements FileService {
    private String domain;

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    @Override
    public boolean saveFile(String key, String content) throws IOException {
        //向域名为domain写入一个test.txt文件，文件内容为“测试内容”
        FileOutputStream outputStream = new FileOutputStream("saestor://sharewith/" + key);
        Writer writer = new OutputStreamWriter(outputStream);
        writer.write(content);
        writer.close();
        return true;
    }



    public void deleteFile(String filename) {

    }

    public String getFile(String filename) throws IOException {
        //读storage中域名为domain，文件名为test.txt的文件
        FileInputStream in = new FileInputStream("saestor://sharewith/" + filename);
       /* Reader reader = new InputStreamReader(inputStream);
        StringBuilder filetext = new StringBuilder();
        int tempchar;
        while ((tempchar = reader.read()) != -1) {
            filetext.append((char) tempchar);
        }
        reader.close();
        return filetext.toString();*/

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

}


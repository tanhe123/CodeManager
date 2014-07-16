package com.xiayule.service.impl;

import com.sina.sae.storage.SaeStorage;
import com.xiayule.service.FileService;

import java.io.*;


/**
 * Created by tan on 14-7-7.
 */
public class SaeFileServiceImpl implements FileService {
    private String domain;
    private String accessKey;
    private String secretKey;
    private String appName;

    private SaeStorage saeStorage;

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    private SaeStorage getSaeStorage() {
        if (saeStorage == null) {
            saeStorage = new SaeStorage(accessKey, secretKey, appName);
        //    saeStorage = new SaeStorage();
        }
        return saeStorage;
    }

    @Override
    public boolean saveFile(String filename, String content) throws IOException {
        //向域名为domain写入一个test.txt文件，文件内容为“测试内容”
     /*   FileOutputStream outputStream = new FileOutputStream("saestor://sharewith/" + filename);
        Writer writer = new OutputStreamWriter(outputStream);
        writer.write(content);
        writer.close();*/

        SaeStorage storage = getSaeStorage();
        storage.write(domain, filename, content.getBytes());

        System.out.println("SaeFileService: fileexsists?" + storage.fileExists(domain, filename));
    //    System.out.println("SaeFileService: fileconent: " + new String(storage.read(domain, filename)));

        return true;
    }

    public void deleteFile(String filename) {
        SaeStorage storage = getSaeStorage();
        saeStorage.delete(domain, filename);
    }

    public String readFileContent(String filename) throws IOException {
     /*   //读storage中域名为domain，文件名为test.txt的文件
        FileInputStream in = new FileInputStream("saestor://sharewith/" + filename);

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
        return result;*/

        SaeStorage saeStorage = getSaeStorage();
        byte[] buf = saeStorage.read(domain, filename);

        return new String(buf);
    }


    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }
}


package com.test;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

import com.xiayule.qrcode.MatrixToImageWriter;
import com.xiayule.qrcode.QRCodeMaker;
import com.xiayule.service.FileService;
import com.xiayule.service.impl.LocalFileServiceImpl;
import com.xiayule.service.impl.QiniuFileServiceImpl;
import com.xiayule.utils.TimeUtil;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

import java.io.*;
import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by tan on 14-6-25.
 */
public class test {

//    public static void main(String[] args) throws Exception {
  /*      // 从业务服务端得到上传凭证
        Config.ACCESS_KEY = "Dch_ifA-S0ffK7_-DC96KuKIA9j6p860Ze37r6Xq";
        Config.SECRET_KEY = "c6p6HS_GOE6_6cTOacHhLQw-UH48GF45Rainq1LG";

        Mac mac = new Mac(Config.ACCESS_KEY, Config.SECRET_KEY);
        String bucketName = "codemanager";
        PutPolicy putPolicy = new PutPolicy(bucketName);
        String uptoken = putPolicy.token(mac);

        // 注：此处的key可以类比数据中表中的主键，此处用上传文件的文件名。
        String key = "a.sh";
        //String dir = System.getProperty("user.dir");
        String dir = "/home/tan/";

        // 本地文件的绝对路径
        //String localFile = dir + "/testdata/" + key;
        String localFile = dir + key;

        System.out.println(localFile);

        // 可选的上传选项，具体说明请参见使用手册。
        PutExtra extra = new PutExtra();

        // 上传文件
        PutRet ret = IoApi.putFile(uptoken, key, localFile, extra);

        if (ret.ok()) {
            System.out.println(ret.getKey());
            System.out.println(ret.);
            System.out.println("Successfully upload the file.");
        } else {
            System.out.println("opps, error : " + ret);
            return;
        }

        */

/*        Config.ACCESS_KEY = "Dch_ifA-S0ffK7_-DC96KuKIA9j6p860Ze37r6Xq";
        Config.SECRET_KEY = "c6p6HS_GOE6_6cTOacHhLQw-UH48GF45Rainq1LG";

        Mac mac = new Mac(Config.ACCESS_KEY, Config.SECRET_KEY);
        String baseUrl = URLUtils.makeBaseUrl("codemanager.qiniudn.com", "a.sh");
        GetPolicy getPolicy = new GetPolicy();
        String downloadUrl = getPolicy.makeRequest(baseUrl, mac);
        System.out.println(downloadUrl);
*/

        // 创建临时文件
//        File file = new File("/tmp/" + TimeUtil.getDate());
//
//        file.createNewFile();

        // 将代码写入临时文件
 //       OutputStream os = new FileOutputStream(file);
//        os.write("test\nnihao\n谭贺".getBytes());
//        os.close();
//
//        System.out.println(file.getName());

        // 测试二维码
 /*       String text = "你好";
        int width = 300;
        int height = 300;
        String format = "png";
        HashMap hints= new HashMap();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        BitMatrix bitMatrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, width, height,hints);
        File outputFile = new File("/tmp/new.png");
        MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);*/
//        File file = new File("/tmp/a.png");
//        QRCodeMaker.writeQRCodeToFile("nihaoma", QRCodeMaker.TYPE_PNG, file, 500, 600);


//    }
/*
    @Test
    public void testDownloadUrl() throws Exception {
        System.out.println("123");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        FileService fileService = (FileService) ctx.getBean("qiniuFileService");
        String filename = "tan_b4_2014-06-28 19:39:28.java";
//        String downloadUrl1 = fileService.getDownloadFileUrl(filename);
//        String downloadUrl2 = fileService.getDownloadFileUrl(filename);
        Assert.assertEquals(downloadUrl1, downloadUrl2);
    }


    @Test
    public void testUpload() throws AuthException, JSONException, FileNotFoundException {
        // 从业务服务端得到上传凭证
        Config.ACCESS_KEY = "Dch_ifA-S0ffK7_-DC96KuKIA9j6p860Ze37r6Xq";
        Config.SECRET_KEY = "c6p6HS_GOE6_6cTOacHhLQw-UH48GF45Rainq1LG";

        Mac mac = new Mac(Config.ACCESS_KEY, Config.SECRET_KEY);
        String bucketName = "codemanager";
        PutPolicy putPolicy = new PutPolicy(bucketName);
        String uptoken = putPolicy.token(mac);

        // 注：此处的key可以类比数据中表中的主键，此处用上传文件的文件名。
  //      String key = "a.sh";
        //String dir = System.getProperty("user.dir");
        String dir = "/home/tan/";

        // 本地文件的绝对路径
        //String localFile = dir + "/testdata/" + key;
//        String localFile = dir + key;

//        System.out.println(localFile);

        // 可选的上传选项，具体说明请参见使用手册。
        PutExtra extra = new PutExtra();

        InputStream inputStream = new BufferedInputStream(new FileInputStream("/home/tan/index.jsp"));
        String key = "a.test";
        // 上传文件
        PutRet ret = IoApi.Put(uptoken, key, inputStream, extra);
    }*/
   /* @Test
    public void testUploadFile() throws IOException {
        String key = "keyk";
        String content = "abcd";
        FileOutputStream outputStream = new FileOutputStream("saestor://sharewith/" + key);
        Writer writer = new OutputStreamWriter(outputStream);
        writer.write(content);
        writer.close();
    }*/



    @Test
    public void testSaveFile() throws IOException {
        LocalFileServiceImpl fileService = new LocalFileServiceImpl();
        fileService.saveFile("tan", "12345");

    }

    @Test
    public void testReadFromFile() throws IOException {
        LocalFileServiceImpl fileService = new LocalFileServiceImpl();
        String content = fileService.getFile("tan");
        Assert.assertEquals(content, "12345");
    }
}

package com.test;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.qiniu.api.auth.digest.Mac;
import com.qiniu.api.config.Config;

import com.qiniu.api.rs.GetPolicy;
import com.qiniu.api.rs.URLUtils;
import com.xiayule.qrcode.MatrixToImageWriter;
import com.xiayule.qrcode.QRCodeMaker;
import com.xiayule.utils.TimeUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by tan on 14-6-25.
 */
public class test {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
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
        File file = new File("/tmp/a.png");
        QRCodeMaker.writeQRCodeToFile("nihaoma", QRCodeMaker.TYPE_PNG, file, 500, 600);
    }
}

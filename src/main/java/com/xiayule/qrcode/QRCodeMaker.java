package com.xiayule.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

/**
 * Created by tan on 14-6-28.
 */
public class QRCodeMaker {
    public static final String TYPE_PNG = "png";

    /**
     * 根据 content 的内容，产生一个二维码，并写入到文件
     * @param content 二维码的内容
     * @param format 二维码图片的格式，例如: "png"
     * @param outputFile 要写入的文件
     * @param width 图片的宽
     * @param height 图片的高
     * @throws WriterException
     * @throws IOException
     */
    @SuppressWarnings("unchecked")
    public static void writeQRCodeToFile(String content, String format, File outputFile, int width, int height) throws WriterException, IOException {
        HashMap hints= new HashMap();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height,hints);
        MatrixToImageWriter.writeToFile(bitMatrix, format, outputFile);
    }

    /**
     * 根据 content 的内容，产生一个二维码，并写入到文件
     * @param content 二维码的内容
     * @param format 二维码图片的格式，例如: "png"
     * @param outputStream 要写入的流
     * @param width 图片的宽
     * @param height 图片的高
     * @throws WriterException
     * @throws IOException
     */
    public static void writeQRCodeToImage(String content, String format, OutputStream outputStream, int width, int height) throws WriterException, IOException {
        HashMap hints= new HashMap();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height,hints);

        MatrixToImageWriter.writeToStream(bitMatrix, format, outputStream);
    }
}

package com.xiayule.utils;

import java.io.*;

/**
 * Created by tan on 14-6-25.
 */
public class FileUtils {
    public static File createTmpFile(String filename) throws IOException {
        File file = new File("/tmp/" + filename);

        file.createNewFile();

        return file;
    }

    public static void writeToFile(File file, String content) throws IOException {
        writeToFile(file, content.getBytes());
    }

    public static void writeToFile(File file, byte[] content) throws IOException {
        // 将代码写入临时文件
        OutputStream os = new FileOutputStream(file);
        os.write(content);
        os.close();
    }

    public static String readFromFile(String filename) throws IOException {
        InputStream in = new FileInputStream(new File(filename));

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

    public static void deleteFile(String filename) {
        File file = new File(filename);
        file.delete();
    }
}

package com.xiayule.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

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
}

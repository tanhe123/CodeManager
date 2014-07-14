package com.xiayule.service.impl;

import com.xiayule.service.FileService;
import com.xiayule.utils.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by tan on 14-7-8.
 */
public class LocalFileServiceImpl implements FileService{
    @Override
    public boolean saveFile(String filename, String content) throws IOException {
        // 将文件放在 /tmp/ 中
        File file = FileUtils.createTmpFile(filename);
        FileUtils.writeToFile(file, content);
        return true;
    }

    @Override
    public String getFileContent(String key) throws IOException {
        // 假设文件全部放在 /tmp 中
        String filename = "/tmp/" + key;
        String content = FileUtils.readFromFile(filename);
        return content;
    }

    @Override
    public void deleteFile(String filename) {
        FileUtils.deleteFile(filename);
    }
}

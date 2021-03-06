package com.xiayule.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by tan on 14-6-25.
 */
public interface FileService {
    public boolean saveFile(String filename, String content) throws IOException;
    public String readFileContent(String filename) throws IOException;
    public void deleteFile(String filename);
}

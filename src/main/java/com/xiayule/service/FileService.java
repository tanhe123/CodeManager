package com.xiayule.service;

import com.qiniu.api.auth.AuthException;
import org.apache.commons.codec.EncoderException;
import org.json.JSONException;

import java.io.File;

/**
 * Created by tan on 14-6-25.
 */
public interface FileService {
    public void setAccessKey(String key);
    public void setSecretKey(String key);
    public void setBucketName(String name);
    public void setDomain(String domain);

    public boolean uploadFile(String path) throws AuthException, JSONException;
    public boolean uploadFile(File file) throws AuthException, JSONException;
    public String getDownloadFileUrl(String filename) throws Exception;
}

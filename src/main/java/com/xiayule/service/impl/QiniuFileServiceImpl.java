package com.xiayule.service.impl;

import com.qiniu.api.auth.AuthException;
import com.qiniu.api.auth.digest.Mac;
import com.qiniu.api.config.Config;
import com.qiniu.api.io.IoApi;
import com.qiniu.api.io.PutExtra;
import com.qiniu.api.io.PutRet;
import com.qiniu.api.rs.GetPolicy;
import com.qiniu.api.rs.PutPolicy;
import com.qiniu.api.rs.URLUtils;
import com.xiayule.service.FileService;
import org.json.JSONException;

import java.io.File;

public class QiniuFileServiceImpl implements FileService {
    private String bucketName;
    private String domain;

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    @Override
    public void setAccessKey(String key) {
        Config.ACCESS_KEY = key;
    }

    @Override
    public void setSecretKey(String key) {
        Config.SECRET_KEY = key;
    }

    public boolean uploadFile(String localFile) throws AuthException, JSONException {
        File file = new File(localFile);
        return uploadFile(file);
    }

    @Override
    public boolean uploadFile(File file) throws AuthException, JSONException {
        Mac mac = new Mac(Config.ACCESS_KEY, Config.SECRET_KEY);
        PutPolicy putPolicy = new PutPolicy(bucketName);
        String uptoken = putPolicy.token(mac);

        // 可选的上传选项，具体说明请参见使用手册。
        PutExtra extra = new PutExtra();

        // 上传文件
        PutRet ret = IoApi.putFile(uptoken, file.getName(), file.getAbsolutePath(), extra);

        if (ret.ok()) {
            return true;
        } else {
            return false;
        }
    }

    public String getDownloadFileUrl(String filename) throws Exception {
        Mac mac = new Mac(Config.ACCESS_KEY, Config.SECRET_KEY);
        String baseUrl = URLUtils.makeBaseUrl(domain, filename);
        GetPolicy getPolicy = new GetPolicy();
        String downloadUrl = getPolicy.makeRequest(baseUrl, mac);
        return downloadUrl;
    }
}

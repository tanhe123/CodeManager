package com.xiayule.domain;

import com.xiayule.service.FileService;
import com.xiayule.service.HttpService;
import com.xiayule.service.impl.QiniuFileServiceImpl;
import com.xiayule.utils.TimeUtil;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by tan on 14-6-22.
 */
public class Code {
    private Integer id;
    private String owner;
    private String source;
    private String title;
    private String type;
    private Calendar date;

    // 用于从服务器获取保存的代码
    private FileService fileService;

    public Code() {
        date = TimeUtil.getCalendar();
    }
/*
    public Code(String title, String owner, String type, String source) {
        this.owner = owner;
        this.source = source;
        this.title = title;
        this.type = type;
        date = TimeUtil.getCalendar();
    }*/

    /**
     * 根据代码的各种属性，生成文件名
     * @return
     */
    public String fileName() {
        String filename = getOwner() + "_" + getTitle() + "_"
                + TimeUtil.getDate(getDate()) + "." + getType();
        return filename;
    }

    public void setFileService(FileService fileService) {
        this.fileService = fileService;
    }

    /**
     * 这里TemporalType.TIMESTAMP表示日期和时间都记录
     * TemporalType.TIME表示只记录时间 TemporalType.DATE表示只记录日期 不过一般我们日期和时间都记录
     * @return 日期
     */
    @Temporal(TemporalType.TIMESTAMP)
    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * 获得保存的代码，需要从服务器中获取
     * @return 保存的代码
     */
    public String getSource() {
        // 如果为空，就需要从服务器中下载
        if (source == null) {
            try {
                //source = updateSource();
                fileService.getFile(fileName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
/*
    private String codeUrl() throws Exception {
        String url = fileService.getDownloadFileUrl(fileName());
        return url;
    }

    @Override
    public String toString() {
        return "title:" + title + "owner:" + owner + " type:" + type;
    }

    /**
     * 从云服务中获取保存的源代码
     */
   /* private String updateSource() throws Exception {
        return HttpService.get(codeUrl());
    }*/
}

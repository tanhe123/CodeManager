package com.xiayule.domain;

import com.xiayule.service.HttpService;
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
    private String codeUrl;
    private Calendar date;

    public Code() {}

    public Code(String title, String owner, String type, String source) {
        this.owner = owner;
        this.source = source;
        this.title = title;
        this.type = type;
        date = TimeUtil.getCalendar();
    }

    /**
     * 根据代码的各种属性，生成文件名
     * @return
     */
    public String fileName() {
        String filename = getOwner() + "_" + getTitle() + "_"
                + TimeUtil.getDate(getDate()) + "." + getType();
        return filename;
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

    public String getSource() {
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

    public String getCodeUrl() {
        return codeUrl;
    }

    public void setCodeUrl(String codeUrl) {
        this.codeUrl = codeUrl;
    }

    @Override
    public String toString() {
        return "title:" + title + "owner:" + owner + " type:" + type + " codeUrl:" + codeUrl;
    }

    /**
     * 从云服务中获取保存的源代码
     */
    public void updateSource() {
        setSource(HttpService.get(getCodeUrl()));
    }
}

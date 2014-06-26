package com.xiayule.domain;

import com.xiayule.service.HttpService;

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

    public Code() {}

    public Code(String title, String owner, String type, String source) {
        this.owner = owner;
        this.source = source;
        this.title = title;
        this.type = type;
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

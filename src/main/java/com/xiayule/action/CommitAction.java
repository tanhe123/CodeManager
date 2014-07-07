package com.xiayule.action;

import com.opensymphony.xwork2.Action;
import com.xiayule.domain.Code;
import com.xiayule.service.CodeService;
import com.xiayule.service.FileService;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

public class CommitAction implements Action {
    //TODO: 加入二维码功能
    //TODO: 短链接
    private CodeService codeService;
    private FileService fileService;

    /**
     * Created by tan on 14-6-23.
     */
    private String owner;
    private String title;
    private String source;
    private String type;

    private Code code;

    public void setCodeService(CodeService codeService) {
        this.codeService = codeService;
    }

    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public void setFileService(FileService fileService) {
        this.fileService = fileService;
    }

    @Override
    public String execute() throws Exception {
        code = new Code();

        code.setTitle(title);
        code.setOwner(owner);
        code.setType(type);
        code.setSource(source);

        // 生成文件名
        String filename = code.fileName();
        // 要上传的文件内容
        String content = code.getSource();

        System.out.println("CommitAction: filename: " + filename);

        // 创建临时文件
        //File file = FileUtils.createTmpFile(filename);
        // 写入文件内容
        //FileUtils.writeToFile(file, code.getSource());
        // 上传文件
        //leService.saveFile(file);
        // 删除临时文件
        //file.delete();

        //TODO: 修改为 sae
        fileService.saveFile(filename, content);

        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("code", code);

        if (codeService.commitCode(code)) {
            return SUCCESS;
        }
        else {
            return ERROR;
        }
    }
}
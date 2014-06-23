package com.xiayule.action;

import com.opensymphony.xwork2.Action;
import com.xiayule.domain.Code;
import com.xiayule.service.CodeService;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by tan on 14-6-23.
 */
public class CommitAction implements Action {
    private CodeService codeService;

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

    @Override
    public String execute() throws Exception {
        code = new Code(title, owner, type, source);
        if (codeService.commitCode(code)) {
            HttpServletRequest request = ServletActionContext.getRequest();
            request.setAttribute("code", code);

            return SUCCESS;
        } else return ERROR;
    }
}

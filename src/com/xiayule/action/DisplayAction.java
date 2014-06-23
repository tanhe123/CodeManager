package com.xiayule.action;

import com.opensymphony.xwork2.Action;
import com.xiayule.domain.Code;
import com.xiayule.service.CodeService;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by tan on 14-6-23.
 */
public class DisplayAction implements Action {
    private CodeService codeService;

    private Integer id;

    public CodeService getCodeService() {
        return codeService;
    }

    public void setCodeService(CodeService codeService) {
        this.codeService = codeService;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String execute() throws Exception {
        Code code = codeService.getCode(id);
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("code", code);
        return SUCCESS;
    }
}

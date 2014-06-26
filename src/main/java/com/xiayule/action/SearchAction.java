package com.xiayule.action;

import com.opensymphony.xwork2.Action;
import com.xiayule.domain.Code;
import com.xiayule.service.CodeService;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by tan on 14-6-22.
 */
public class SearchAction implements Action {
    private String owner;

    private CodeService codeService;
    private List<Code> codes;

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public void setCodeService(CodeService codeService) {
        this.codeService = codeService;
    }

    public List<Code> getCodes() {
        return codes;
    }

    public void setCodes(List<Code> codes) {
        this.codes = codes;
    }

    @Override
    public String execute() throws Exception {
        codes = codeService.searchCode(owner);
        HttpServletRequest request = ServletActionContext.getRequest();

        request.setAttribute("owner", owner);
        request.setAttribute("codes", codes);

        return SUCCESS;
    }
}

package com.xiayule.action;

import com.opensymphony.xwork2.Action;
import com.xiayule.domain.Code;
import com.xiayule.qrcode.QRCodeMaker;
import com.xiayule.service.CodeService;
import com.xiayule.service.FileService;
import com.xiayule.service.HttpService;
import org.apache.http.client.HttpClient;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;

/**
 * Created by tan on 14-6-23.
 */
public class DisplayAction implements Action {
    private CodeService codeService;
    private Integer id;

    @Override
    public String execute() throws Exception {
        Code code = codeService.getCode(id);
        HttpServletRequest request = ServletActionContext.getRequest();

        // 更新源代码
  //      code.updateSource();

        request.setAttribute("code", code);
        return SUCCESS;
    }

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
}

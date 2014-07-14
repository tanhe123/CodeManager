package com.xiayule.action;

import com.opensymphony.xwork2.Action;
import com.xiayule.dao.CodeDao;
import com.xiayule.domain.Code;
import com.xiayule.service.CodeService;
import com.xiayule.service.FileService;

/**
 * Created by tan on 14-6-27.
 */
public class DeleteAction implements Action {
    private CodeService codeService;
    private FileService fileService;

    private Integer id;

    public void setFileService(FileService fileService) {
        this.fileService = fileService;
    }

    public void setCodeService(CodeService codeService) {
        this.codeService = codeService;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }


    @Override
    public String execute() throws Exception {

        Code code = codeService.getCode(id);
    //    fileService.deleteFile(code.);
    //    codeService.deleteCode(id);

        System.out.println("DeleteAcion:" + "正在删除" + code);

        fileService.deleteFile(code.fileName());
        codeService.deleteCode(code);

        return SUCCESS;
    }
}

package com.xiayule.service.impl;

import com.xiayule.dao.CodeDao;
import com.xiayule.domain.Code;
import com.xiayule.service.CodeService;
import com.xiayule.service.FileService;

import java.util.List;

/**
 * Created by tan on 14-6-22.
 */
public class CodeServiceImpl implements CodeService{
    private FileService fileService;

    private CodeDao codeDao;

    public void setCodeDao(CodeDao codeDao) {
        this.codeDao = codeDao;
    }

    @Override
    public boolean commitCode(Code code) {
        if (codeDao.save(code) > 0) return true;
        else return false;
    }

    @Override
    public List<Code> searchCode(String owner) {
        List<Code> codes = codeDao.findByOwner(owner);
        return codes;
    }

    public void setFileService(FileService fileService) {
        this.fileService = fileService;
    }

    @Override
    public void deleteCode(Code code) {
        codeDao.delete(code);
    }

    @Override
    public void deleteCode(Integer id) {
        codeDao.delete(id);
    }

    @Override
    public void updateCode(Code code) {
        codeDao.update(code);
    }

    public Code getCode(Integer id) {
        Code code = codeDao.get(id);
        // TODO: 不知道如何从 hibernate 中取出自动注入，暂时这样解决
        code.setFileService(fileService);
        return code;
    }
}

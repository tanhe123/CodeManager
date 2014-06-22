package com.xiayule.service.impl;

import com.xiayule.dao.CodeDao;
import com.xiayule.domain.Code;
import com.xiayule.service.CodeService;

/**
 * Created by tan on 14-6-22.
 */
public class CodeServiceImpl implements CodeService{

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
    public void updateCode(Code code) {
        codeDao.update(code);
    }
}

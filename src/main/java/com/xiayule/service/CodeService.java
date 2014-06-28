package com.xiayule.service;

import com.xiayule.dao.CodeDao;
import com.xiayule.domain.Code;

import java.util.List;

/**
 * Created by tan on 14-6-22.
 */
public interface CodeService {
    public boolean commitCode(Code code);
    public void updateCode(Code code);
    public void deleteCode(Code code);
    public void deleteCode(Integer id);
    public List<Code> searchCode(String owner);
    public Code getCode(Integer id);
}

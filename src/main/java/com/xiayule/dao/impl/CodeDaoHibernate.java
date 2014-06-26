package com.xiayule.dao.impl;

import com.xiayule.dao.CodeDao;
import com.xiayule.domain.Code;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by tan on 14-6-10.
 */
@SuppressWarnings("unchecked")
public class CodeDaoHibernate extends HibernateDaoSupport implements CodeDao {
    @Override
    public Code get(Integer id) {
        return getHibernateTemplate()
                .get(Code.class, id);
    }

    @Override
    public Integer save(Code code) {
        return (Integer) getHibernateTemplate()
                .save(code);
    }

    @Override
    public void update(Code code) {
        getHibernateTemplate().update(code);
    }

    @Override
    public void delete(Integer id) {
        getHibernateTemplate().delete(get(id));
    }

    @Override
    public void delete(Code code) {
        getHibernateTemplate().delete(code);
    }

    @Override
    public List<Code> findByOwner(String owner) {
        return (List<Code>)getHibernateTemplate()
                .find("from Code c where c.owner = ?", owner);
    }

    @Override
    public List findAllPerson() {
        return (List<Code>)getHibernateTemplate().find("from Code");
    }

    @Override
    public long getPersonNumber() {
        return (Long) getHibernateTemplate().find
                ("select count(*) from Code as c")
                .get(0);
    }
}

package com.xiayule.dao;

import com.xiayule.domain.Code;

import java.util.List;

/**
 * Description:
 * <br/>网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
 * <br/>Copyright (C), 2001-2012, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
public interface CodeDao
{
    /**
     * 加载Person实例
     * @param id 需要加载的Person实例的主键值
     * @return 返回加载的Person实例
     */
    Code get(Integer id);

    /**
     * 保存Person实例
     * @param code 需要保存的code实例
     * @return 刚刚保存的Person实例的标识属性值
     */
    Integer save(Code code);

    /**
     * 修改Person实例
     * @param code 需要修改的code实例
     */
    void update(Code code);

    /**
     * 删除Person实例
     * @param id 需要删除的Person实例的标识属性值
     */
    void delete(Integer id);

    /**
     * 删除Person实例
     * @param code 需要删除的Person实例
     */
    void delete(Code code);

    /**
     * 根据用户名查找Person
     * @param owner 查询的人名
     * @return 指定用户名对应的全部Person
     */
    List<Code> findByName(String owner);

    /**
     * 查询全部Person实例
     * @return 全部Person实例
     */
    public List findAllPerson();

    /**
     * 查询数据表中Person实例的总数
     * @return 数据表中Person实例的总数
     */
    long getPersonNumber();
}
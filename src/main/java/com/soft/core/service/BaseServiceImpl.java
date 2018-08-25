/*
 * Copyright (c)
 */
package com.soft.core.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.soft.core.mapper.BaseMapper;
import org.apache.commons.collections4.MapUtils;

import java.util.List;
import java.util.Map;

/**
 * 基本业务实现
 *
 * @author David Lin
 * @version: 1.0
 * @date 2018-08-13 21:56
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {
    /**
     * 获取mapper对象
     * @return
     */
    protected abstract BaseMapper<T> getMapper();

    /**
     * 根据ID获取实体对象
     *
     * @param primaryKeyId
     * @return
     */
    public T getById(String primaryKeyId) {
        return getMapper().getById(primaryKeyId);
    }

    /**
     * 根据条件获取单个实体对象
     *
     * @param model
     * @return
     */
    public T getRecord(T model) {
        return  getMapper().getRecord(model);
    }

    /**
     * 根据条件查询记录列表
     *
     * @param model
     * @return
     */
    public List<T> findRecord(T model) {
        return  getMapper().findRecord(model);
    }

    /**
     * 保存
     *
     * @param model
     * @return
     */
    public int saveRecord(T model) {
        return  getMapper().saveRecord(model);
    }

    /**
     * 更新
     *
     * @param model
     * @return
     */
    public int modifyRecord(T model) {
        return  getMapper().modifyRecord(model);
    }

    /**
     * 删除
     *
     * @param colValues
     * @return
     */
    public int removeRecords(String[] colValues) {
        return  getMapper().removeRecords(colValues);
    }

    /**
     * 通用分页
     *
     * @param params
     * @return
     */
    @Override
    public PageInfo<T> datagrid(Map<String, Object> params) {
        int pageNum = MapUtils.getInteger(params,"pageNum");
        int pageSize = MapUtils.getInteger(params,"pageSize");
        String orderBｙ = MapUtils.getString(params,"orderstr");
        PageHelper.startPage(pageNum,pageSize);
        PageHelper.orderBy(orderBｙ);
        List<T> list = getMapper().findList(params);
        PageInfo<T> pageInfo  = new PageInfo<>(list);
        return pageInfo;
    }
}

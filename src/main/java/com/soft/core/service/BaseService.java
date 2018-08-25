/*
 * Copyright (c)
 */
package com.soft.core.service;

import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * 基本业务骨架接口
 *
 * @author David Lin
 * @version: 1.0
 * @date 2018-08-13 21:40
 */
public interface BaseService<T> {
    /**
     * 根据ID获取实体对象
     * @param primaryKeyId
     * @return
     */
    T getById(String primaryKeyId);

    /**
     * 根据条件获取单个实体对象
     * @param model
     * @return
     */
    T getRecord(T model);

    /**
     * 根据条件查询记录列表
     * @param model
     * @return
     */
    List<T> findRecord(T model);

    /**
     * 保存
     * @param model
     * @return
     */
    int saveRecord(T model);

    /**
     * 更新
     * @param model
     * @return
     */
    int modifyRecord(T model);

    /**
     * 删除
     * @param colValues
     * @return
     */
    int removeRecords(String[] colValues);

    /**
     * 通用分页
     * @param params
     * @return
     */
    PageInfo<T> datagrid(Map<String,Object> params);
}

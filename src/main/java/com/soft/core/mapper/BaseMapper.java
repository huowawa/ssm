/*
 * Copyright (c)
 */
package com.soft.core.mapper;

import java.util.List;
import java.util.Map;

/**
 * 基本sql操作映射
 *
 * @author David Lin
 * @version: 1.0
 * @date 2018-08-13 22:01
 */
public interface BaseMapper<T> {
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
     * 根据条件查询记录列表
     * @param params
     * @return
     */
    List<T> findList(Map<String,Object> params);

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



}

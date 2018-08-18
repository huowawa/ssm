/*
 * Copyright (c)
 */
package com.soft.platform.developer.service;

import com.soft.platform.developer.model.TableColumn;

import java.util.List;

/**
 * 数据库表列业务
 *
 * @author David Lin
 * @version: 1.0
 * @date 2018-08-11 18:30
 */
public interface TableColumnService {
    /**
     * 根据表名称获取该表的字段
     * @param tableName
     * @return
     */
    List<TableColumn> findOracleTableColumns(String tableName);
    /**
     * 根据表名称获取主键列名称
     * @param tableName
     * @return
     */
    String getPrimaryKey(String tableName);

}

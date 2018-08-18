/*
 * Copyright (c)
 */
package com.soft.platform.developer.mapper;

import com.soft.platform.developer.model.TableColumn;

import java.util.List;

/**
 * 数据库表列映射
 *
 * @author David Lin
 * @version: 1.0
 * @date 2018-08-11 18:05
 */
public interface TableColumnMapper {
    /**
     * 根据表名称获取列信息
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

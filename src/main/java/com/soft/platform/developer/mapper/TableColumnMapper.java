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
    List<TableColumn> findOracleTableColumns(String tableName);
}

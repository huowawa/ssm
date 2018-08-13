/*
 * Copyright (c)
 */
package com.soft.platform.developer.service.impl;

import com.soft.platform.developer.mapper.TableColumnMapper;
import com.soft.platform.developer.model.TableColumn;
import com.soft.platform.developer.service.TableColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

    /**
     * 数据库表信息
     *
     * @author David Lin
     * @version: 1.0
     * @date 2018-08-11 18:34
     */
    @Service
    public class TableColumnServiceImpl implements TableColumnService {

        /**
         * 表映射器
         */
    @Autowired
    private TableColumnMapper mapper;

    @Override
    public List<TableColumn> findOracleTableColumns(String tableName) {
        List<TableColumn> columns = new ArrayList<>(16);
        List<TableColumn> columnList = mapper.findOracleTableColumns(tableName);
        for (TableColumn col : columnList) {
            genComplateColumn(col);
            columns.add(col);
        }

        return columns;
    }

    private void genComplateColumn(TableColumn col) {
        col.setOldColumnName(col.getColumnName());
        String isNullable = col.getIsNullable();
        String dataType = col.getDataType();
        String columnType = "String";

        if (dataType.contains("CHAR")) {
            columnType = "String";
        } else if (dataType.contains("NUMBER")) {
            columnType = "BigDecimal";
        } else if (dataType.contains("DATE")) {
            columnType = "Timestamp";
        }
        col.setDataType(columnType);

        if ("-1".equals(isNullable)) {
            col.setIsNullable("-1");
        } else {
            col.setIsNullable("1");
        }

    }
}

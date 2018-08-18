/*
 * Copyright (c)
 */
package com.soft.platform.developer.service.impl;

import com.soft.core.util.ConvertUtil;
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

        /**
         * 根据表名称获取主键列名称
         *
         * @param tableName
         * @return
         */
        @Override
        public String getPrimaryKey(String tableName) {
            return mapper.getPrimaryKey(tableName);
        }

        private void genComplateColumn(TableColumn col) {
        col.setColumnNameField(ConvertUtil.camelName(col.getColumnName()));
        col.setLowerCaseColumn(col.getColumnName().toLowerCase());
        String isNullable = col.getIsNullable();
        String dataType = col.getDataType();
        String columnType = "String";
        String jdbcType = "VARCHAR";

        if (dataType.contains("CHAR")) {
            columnType = "String";
        } else if (dataType.contains("NUMBER")) {
            columnType = "BigDecimal";
            jdbcType = "DOUBLE";
        } else if (dataType.contains("DATE")) {
            columnType = "Timestamp";
            jdbcType = "DATE";
        }else if(dataType.contains("CLOB")){
            columnType = "String";
            jdbcType = "CLOB";
        }else if(dataType.contains("TIMESTAMP")){
            columnType = "Timestamp";
            jdbcType = "TIMESTAMP";
        }
        col.setDataType(columnType);
        col.setJdbcType(jdbcType);

        if ("-1".equals(isNullable)) {
            col.setIsNullable("-1");
        } else {
            col.setIsNullable("1");
        }

    }
}

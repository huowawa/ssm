/*
 * Copyright (c)
 */
package com.soft.platform.developer.model;

/**
 * 数据库表列信息
 *
 * @author David Lin
 * @version: 1.0
 * @date 2018-08-11 17:55
 */
public class TableColumn {
    /**
     * 字符串类型
     */
    public static final int COLUMNTYPE_STRING = 1;
    /**
     * 数字类型
     */
    public static final int COLUMNTYPE_NUMBER = 2;
    /**
     * 日期类型
     */
    public static final int COLUMNTYPE_DATE = 3;
    /**
     * 时间戳类型
     */
    public static final int COLUMNTYPE_TIMESTRAMP = 4;
    /**
     * 大文本类型
     */
    public static final int COLUMNTYPE_TEXT = 5;
    /**
     * 列ID
     */
    private String columnId;

    /**
     * 列名称
     */
    private String columnName;
    /**
     * 小写形式的列名称
     */
    private String lowerCaseColumn;
    /**
     * 列注释
     */
    private String columnComments;
    /**
     * 列类型(1:字符串 2:数字 3:日期  4:时间戳  5:大文本)
     */
    private String dataType;
    /**
     * 当列为字符串类型的时候,它的长度
     */
    private String dataLength;
    /**
     * 是否允许空
     * 1:允许 -1:不允许
     */
    private String isNullable;
    /**
     * 缺省值
     */
    private String defaultValue;
    /**
     * 是否主键(1:是 -1:否)
     */
    private String isPrimaryKey;
    /**
     * 是否唯一性(1:是 -1:否)
     */
    private String isUnique;
    /**
     * 是否外键(1:是 -1:否)
     */
    private String isForeign;
    /**
     * 外键引用表名称
     */
    private String foreignRefTableName;
    /**
     * 外键应用表的列名称
     */
    private String foreignRefColumnName;
    /**
     * 转成驼峰命名法后的名称
     */
    private String columnNameField;
    /**
     * 是否是新增的列 1:是 -1:不是
     */
    private String isNewColumn;
    /**
     * 所处的表名称
     */
    private String tableName;
    /**
     * jdbcType
     */
    private String jdbcType;

    /**
     * @return the tableName
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * @param tableName the tableName to set
     */
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    /**
     * @return the columnName
     */
    public String getColumnName() {
        return columnName;
    }

    /**
     * @param columnName the columnName to set
     */
    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    /**
     * @return the columnComments
     */
    public String getColumnComments() {
        return columnComments;
    }

    /**
     * @param columnComments the columnComments to set
     */
    public void setColumnComments(String columnComments) {
        this.columnComments = columnComments;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    /**
     * @return the dataLength
     */
    public String getDataLength() {
        return dataLength;
    }

    /**
     * @param dataLength the dataLength to set
     */
    public void setDataLength(String dataLength) {
        this.dataLength = dataLength;
    }

    /**
     * @return the isNullable
     */
    public String getIsNullable() {
        return isNullable;
    }

    /**
     * @param isNullable the isNullable to set
     */
    public void setIsNullable(String isNullable) {
        this.isNullable = isNullable;
    }

    /**
     * @return the isPrimaryKey
     */
    public String getIsPrimaryKey() {
        return isPrimaryKey;
    }

    /**
     * @param isPrimaryKey the isPrimaryKey to set
     */
    public void setIsPrimaryKey(String isPrimaryKey) {
        this.isPrimaryKey = isPrimaryKey;
    }

    /**
     * @return the isUnique
     */
    public String getIsUnique() {
        return isUnique;
    }

    /**
     * @param isUnique the isUnique to set
     */
    public void setIsUnique(String isUnique) {
        this.isUnique = isUnique;
    }

    /**
     * @return the isForeign
     */
    public String getIsForeign() {
        return isForeign;
    }

    /**
     * @param isForeign the isForeign to set
     */
    public void setIsForeign(String isForeign) {
        this.isForeign = isForeign;
    }

    /**
     * @return the foreignRefTableName
     */
    public String getForeignRefTableName() {
        return foreignRefTableName;
    }

    /**
     * @param foreignRefTableName the foreignRefTableName to set
     */
    public void setForeignRefTableName(String foreignRefTableName) {
        this.foreignRefTableName = foreignRefTableName;
    }

    /**
     * @return the foreignRefColumnName
     */
    public String getForeignRefColumnName() {
        return foreignRefColumnName;
    }

    /**
     * @param foreignRefColumnName the foreignRefColumnName to set
     */
    public void setForeignRefColumnName(String foreignRefColumnName) {
        this.foreignRefColumnName = foreignRefColumnName;
    }

    /**
     * @return the defaultValue
     */
    public String getDefaultValue() {
        return defaultValue;
    }

    /**
     * @param defaultValue the defaultValue to set
     */
    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getColumnNameField() {
        return columnNameField;
    }

    public void setColumnNameField(String columnNameField) {
        this.columnNameField = columnNameField;
    }

    /**
     * @return the isNewColumn
     */
    public String getIsNewColumn() {
        return isNewColumn;
    }

    /**
     * @param isNewColumn the isNewColumn to set
     */
    public void setIsNewColumn(String isNewColumn) {
        this.isNewColumn = isNewColumn;
    }

    /**
     * @return the columnId
     */
    public String getColumnId() {
        return columnId;
    }

    /**
     * @param columnId the columnId to set
     */
    public void setColumnId(String columnId) {
        this.columnId = columnId;
    }

    public String getLowerCaseColumn() {
        return lowerCaseColumn;
    }

    public void setLowerCaseColumn(String lowerCaseColumn) {
        this.lowerCaseColumn = lowerCaseColumn;
    }

    public String getJdbcType() {
        return jdbcType;
    }

    public void setJdbcType(String jdbcType) {
        this.jdbcType = jdbcType;
    }
}

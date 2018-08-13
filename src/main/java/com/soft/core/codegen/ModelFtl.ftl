/*
 * Copyright (c)
 */
 
package  com.soft.platform.${packageName}.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 描述   ${entityName}实体对象
 * @author ${author}
 * @version 1.0
 * @created ${currDate}
 */
public class ${className} implements java.io.Serializable  {
    <#list columns as column>
    /**
     * ${column.comments!"注释"}
     */
    private ${column.dataType} ${column.columnName};
    </#list>
    
    <#list columns as column>
    public ${column.dataType} get${column.columnName?cap_first}() {
        return ${column.columnName};
    }
    public void set${column.columnName?cap_first}(${column.dataType} ${column.columnName}) {
        this.${column.columnName} = ${column.columnName};
    }
    </#list>


}

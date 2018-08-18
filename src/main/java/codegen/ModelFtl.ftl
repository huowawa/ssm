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
     /**
     * 主键
     */
    private String ${primarykeyProper};

    <#list columns as column>
    /**
     * ${column.columnComments!"注释"}
     */
    private ${column.dataType} ${column.columnNameField};
    </#list>

   public String get${primarykeyProper?cap_first}(){
        return ${primarykeyProper};
    }

    public void set${primarykeyProper?cap_first}(String ${primarykeyProper}){
        this.${primarykeyProper} = ${primarykeyProper};
    }
    <#list columns as column>
    public ${column.dataType} get${column.columnNameField?cap_first}() {
        return ${column.columnNameField};
    }
    public void set${column.columnNameField?cap_first}(${column.dataType} ${column.columnNameField}) {
        this.${column.columnNameField} = ${column.columnNameField};
    }
    </#list>


}

/*
 * Copyright (c) 2005, 2018, EVECOM Technology Co.,Ltd. All rights reserved.
 * EVECOM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */
 
package net.evecom.${packageName}.vmodel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 描述  ${entityName}VO对象
 * @author ${author}
 * @version 1.0
 * @created ${currDate}
 */

public class V${className} implements java.io.Serializable  {
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

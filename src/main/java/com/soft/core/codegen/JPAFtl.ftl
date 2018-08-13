/*
 * Copyright (c) 2005, 2018, EVECOM Technology Co.,Ltd. All rights reserved.
 * EVECOM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */
package net.evecom.${packageName}.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import net.evecom.common.dao.BaseJPA;
import net.evecom.${packageName}.model.${className};

/**
 * 描述   ${entityName}操作jpa
 * @author ${author}
 * @version 1.0
 * @created ${currDate}
 */
@Repository("${className?uncap_first}JPA")
public interface ${className}JPA extends BaseJPA<${className}, String> {

}

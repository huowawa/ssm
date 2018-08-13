/*
 * Copyright (c)
 */
package com.soft.platform.developer.controller;

import com.soft.platform.developer.model.TableColumn;
import com.soft.platform.developer.service.TableColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 表信息控制器
 *
 * @author David Lin
 * @version: 1.0
 * @date 2018-08-11 18:46
 */
@RestController
@RequestMapping("/table")
public class TableColumnController {
    /**
     * 表信息属性
     */
    @Autowired
    private TableColumnService tableColumnService;

    @RequestMapping("/findcolumn")
    public List<TableColumn> findOracleTableColumns(HttpServletRequest request){

        return tableColumnService.findOracleTableColumns("MYAPP_SYSTEM_SYSUSER");
    }
}

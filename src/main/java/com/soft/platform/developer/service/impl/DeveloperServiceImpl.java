/*
 * Copyright (c)
 */
package com.soft.platform.developer.service.impl;

import com.soft.core.util.FreeMarkerUtil;
import com.soft.core.util.PlatPropertiesUtil;
import com.soft.platform.developer.model.TableColumn;
import com.soft.platform.developer.service.DeveloperService;
import com.soft.platform.developer.service.TableColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 开发
 *
 * @author David Lin
 * @version: 1.0
 * @date 2018-08-11 23:35
 */
@Service
public class DeveloperServiceImpl implements DeveloperService {

    /**
     * 表信息属性
     */
    @Autowired
    private TableColumnService tableColumnService;


    @Override
    public void genCode(Map<String, Object> paramMap) throws Exception {
        // 获取模块包名称 fdaks
        String packageName = paramMap.get("packagename").toString();
        // 获取数据库表名称
        String tableName = paramMap.get("tablename").toString();
        // 获取CLASS名称
        String className = paramMap.get("classname").toString();
        // 获取实体中文名称
        String entityName = paramMap.get("entityname").toString();

        List<TableColumn> tableColumns = tableColumnService.findOracleTableColumns(tableName.toUpperCase());
        String primarykeyName = tableColumnService.getPrimaryKey(tableName.toUpperCase());

        String author = PlatPropertiesUtil.getPropertiesByPath("/conf/config.properties").getProperty("author");
        String format = "yyyy年MM月dd日  HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String currDate = sdf.format(new Date());
        StringBuilder baseColumns = new StringBuilder(128);
        int index = 0;
        int removeIndex = 0;

        Map<String, Object> root = new HashMap<String, Object>(8);
        root.put("packageName", packageName);
        root.put("tableName", tableName);
        root.put("className", className);
        root.put("entityName", entityName);

        root.put("author", author);
        root.put("currDate", currDate);
        for (TableColumn curCol : tableColumns) {
            if(curCol.getColumnName().equals(primarykeyName)){
                root.put("parimarykeyname",curCol.getLowerCaseColumn());
                root.put("primarykeyJdbcType",curCol.getJdbcType());
                root.put("primarykeyProper",curCol.getColumnNameField());
                removeIndex = index;
            }
            index+=1;
            baseColumns.append(curCol.getLowerCaseColumn()).append(",");
        }
        tableColumns.remove(removeIndex);
        root.put("columns", tableColumns);
        root.put("base_column_list",baseColumns.substring(0,baseColumns.length()-1));
        root.put("bigleft","{");

        //获取项目地址
        String projectPath = PlatPropertiesUtil.getPropertiesByPath("/conf/config.properties").getProperty("projectpath");

        // 生成简单业务的CRUD代码
        this.genServerSimpleCrudCode(projectPath, root);


    }

    private void genServerSimpleCrudCode(String projectPath, Map<String, Object> root) {
        String packageName = root.get("packageName").toString();
        String className = root.get("className").toString();

        // 定义生成Dao字符串模板
        // 设置dao代码的生成路径
        String daoPath = projectPath + "src/main/java/com/soft/platform/" + packageName + "/mapper/";
        FreeMarkerUtil.writeFileToDisk("MapperFtl.ftl", root, daoPath + className + "Mapper.java");

        // 设置daoImp代码的生成路径
        String daoImplPath = projectPath + "src/main/resources/mapper/"+ packageName +"/";
        FreeMarkerUtil.writeFileToDisk("MapperXmlFtl.ftl", root, daoImplPath + className + "Mapper.xml");

        // 设置model代码的生成路径
        String modelPath = projectPath + "src/main/java/com/soft/platform/" + packageName + "/model/";
        FreeMarkerUtil.writeFileToDisk("ModelFtl.ftl", root, modelPath + className + ".java");


    /*    // 设置Vmodel生成路径
        String vmodelPath = projectPath + "src/main/java/com/soft/platform/" + packageName + "/vmodel/";
        FreeMarkerUtil.writeFileToDisk("VModelFtl.ftl", root, vmodelPath + "V" + className + ".java");*/

        // 设置service代码的生成路径
        String servicePath = projectPath + "src/main/java/com/soft/platform/" + packageName + "/service/";
        FreeMarkerUtil.writeFileToDisk("ServiceFtl.ftl", root, servicePath + className + "Service.java");

        // 设置serviceImpl代码的生成路径
        String serviceImplPath = projectPath + "src/main/java/com/soft/platform/" + packageName + "/service/impl/";
        FreeMarkerUtil.writeFileToDisk("ServiceImplFtl.ftl", root, serviceImplPath + className
                + "ServiceImpl.java");
        // 设置action代码的生成路径
        String actionPath = projectPath + "src/main/java/com/soft/platform/" + packageName + "/controller/";

        FreeMarkerUtil.writeFileToDisk("ActionFtl.ftl", root, actionPath + className + "Controller.java");

    }
}

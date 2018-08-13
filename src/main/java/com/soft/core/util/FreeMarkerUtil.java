/*
 * Copyright (c) 2005, 2014, EVECOM Technology Co.,Ltd. All rights reserved.
 * EVECOM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.soft.core.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Map;

/**
 * @author David Lin
 */
public class FreeMarkerUtil {
    /**
     * 根据文件的名称获取到模板
     *
     * @param name
     * @return
     * @author Perfect Guo
     */
    public static Template getTemplate(String name) {
        Configuration cfg = new Configuration();
        cfg.setClassForTemplateLoading(FreeMarkerUtil.class, "/com/soft/core/codegen");
        try {
            return cfg.getTemplate(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 写入模板结果到磁盘
     *
     * @param root
     * @param tplString
     * @param filePath
     * @author Neil Yu
     */
    public static void writeFileToDisk(Map<String, Object> root,
                                       String tplString, String filePath) {
        Configuration cfg = new Configuration();
        cfg.setTemplateLoader(new StringTemplateLoader(tplString));
        cfg.setDefaultEncoding("UTF-8");
        Template template;
        OutputStreamWriter out = null;
        try {
            template = cfg.getTemplate("");
            File codeFile = new File(filePath);
            if (codeFile.exists()) {
                codeFile.delete();
            }
            String folderPath = filePath
                    .substring(0, filePath.lastIndexOf("/"));
            File file = new File(folderPath);
            if (!file.exists()) {
                file.mkdirs();
            }
            out = new OutputStreamWriter(new FileOutputStream(filePath, true),
                    "UTF-8");
            template.process(root, out);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成文件到磁盘
     *
     * @param ftlFileName :ftl文件名称
     * @param root        :数据根
     * @param filePath    :输出文件的路径
     * @author Perfect Guo
     */
    public static void writeFileToDisk(String ftlFileName,
                                       Map<String, Object> root, String filePath) {
        OutputStreamWriter out = null;
        // FileWriter out = null;
        try {
            File codeFile = new File(filePath);
            if (codeFile.exists()) {
                codeFile.delete();
            }
            String folderPath = filePath
                    .substring(0, filePath.lastIndexOf("/"));
            File file = new File(folderPath);
            if (!file.exists()) {
                file.mkdirs();
            }
            out = new OutputStreamWriter(new FileOutputStream(filePath, true),
                    "UTF-8");
            // out= new FileWriter(new File(filePath));
            Template temp = FreeMarkerUtil.getTemplate(ftlFileName);
            temp.process(root, out);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TemplateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}

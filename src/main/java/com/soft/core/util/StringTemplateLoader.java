/*
 * Copyright (c) 2005, 2014, EVECOM Technology Co.,Ltd. All rights reserved.
 * EVECOM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */
package com.soft.core.util;

import freemarker.cache.TemplateLoader;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述
 *
 * @author Flex Hu
 * @version 1.0
 * @created 2014年9月16日 上午10:13:10
 */
public class StringTemplateLoader implements TemplateLoader {
    /**
     * 缺省KEY
     */
    private static final String DEFAULT_TEMPLATE_KEY = "_default_template_key";
    /**
     * 缺省模版
     */
    private Map templates = new HashMap();

    /**
     * 描述
     *
     * @param defaultTemplate
     * @author Flex Hu
     * @created 2014年9月16日 上午10:13:42
     */
    public StringTemplateLoader(String defaultTemplate) {
        if (defaultTemplate != null && !defaultTemplate.equals("")) {
            templates.put(DEFAULT_TEMPLATE_KEY, defaultTemplate);
        }
    }

    /**
     * 描述
     *
     * @param name
     * @param template
     * @author Flex Hu
     * @created 2014年9月16日 上午10:13:47
     */
    public void addTemplate(String name, String template) {
        if (name == null || template == null || name.equals("")
                || template.equals("")) {
            return;
        }
        if (!templates.containsKey(name)) {
            templates.put(name, template);
        }
    }

    /**
     * 描述
     *
     * @param templateSource
     * @throws IOException
     * @author Flex Hu
     * @created 2014年9月16日 上午10:13:51
     * @see TemplateLoader#closeTemplateSource(Object)
     */
    public void closeTemplateSource(Object templateSource) throws IOException {

    }

    /**
     * 描述
     *
     * @param name
     * @return
     * @throws IOException
     * @author Flex Hu
     * @created 2014年9月16日 上午10:13:54
     * @see TemplateLoader#findTemplateSource(String)
     */
    public Object findTemplateSource(String name) throws IOException {
        if (name == null || name.equals("")) {
            name = DEFAULT_TEMPLATE_KEY;
        }
        return templates.get(name);
    }

    /**
     * 描述
     *
     * @param templateSource
     * @return
     * @author Flex Hu
     * @created 2014年9月16日 上午10:13:57
     * @see TemplateLoader#getLastModified(Object)
     */
    public long getLastModified(Object templateSource) {
        return 0;
    }

    /**
     * 描述
     *
     * @param templateSource
     * @param encoding
     * @return
     * @throws IOException
     * @author Flex Hu
     * @created 2014年9月16日 上午10:14:00
     * @see TemplateLoader#getReader(Object, String)
     */
    public Reader getReader(Object templateSource, String encoding) throws IOException {
        return new StringReader((String) templateSource);
    }

}

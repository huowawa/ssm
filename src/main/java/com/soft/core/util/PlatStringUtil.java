/*
 * Copyright (c)
 */
package com.soft.core.util;

import org.apache.commons.io.IOUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * 字符串相关操作工具类
 *
 * @author David Lin
 * @version: 1.0
 * @date 2018-09-11 22:15
 */
public class PlatStringUtil {

    /**
     * input字节流转换成String字符串
     * @param inputStream
     * @return
     * @throws Exception
     */
    public static String inputStream2String(InputStream inputStream) throws  Exception{
        if(null == inputStream){
            return "";
        }
        byte[] temp = new byte[inputStream.available()];
        inputStream.read(temp);
        String result = new String(temp);
        return result;
    }

    /**
     *
     * @param inputStream
     * @return
     * @throws Exception
     */
    public static String convert2String(InputStream inputStream) throws  Exception{
        if(null == inputStream){
            return "";
        }
        StringWriter writer = new StringWriter();
        IOUtils.copy(inputStream,writer, StandardCharsets.UTF_8.name());
        return writer.toString();
    }

    public static String stream2String(InputStream inputStream) throws  Exception{
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length = 0;
        while((length = inputStream.read(buffer))!=-1){
            outputStream.write(buffer,0,length);
        }
        return outputStream.toString(StandardCharsets.UTF_8.name());
    }

    /**
     * 字符串转字节输入流
     * @param str
     * @return
     */
    public static InputStream string2InputStream(String str){
        if(null == str){
            return null;
        }
        InputStream inputStream = new ByteArrayInputStream(str.getBytes(Charset.forName("UTF-8")));
        return inputStream;
    }
}

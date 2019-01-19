/*
 * Copyright (c)
 */
package com.soft.platform.system.controller;

import com.soft.platform.system.model.Author;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * 上传控制器
 *
 * @author David Lin
 * @version: 1.0
 * @date 2018-11-05 21:53
 */
@Controller
public class FileUploadController {

    /**
     * 跳转上传页面
     * @param request
     * @return
     */
    @RequestMapping("/toupload")
    public ModelAndView jumpToUpload(HttpServletRequest request){
        return new ModelAndView("test/uploadTest");
    }

    /**
     * 上传处理
     * @return
     */
    @RequestMapping("/upload")
    @ResponseBody
    public  String upload(HttpServletRequest request,
                          @RequestParam("file") MultipartFile file) throws Exception {
        //文件说明
        String desc = request.getParameter("desc");
        System.out.println(desc);
        //保存路径  可配置在properties文件里面
        String attachFilePath ="D:/AttachFiles/";

        if(file.isEmpty()){
            return "error";
        }
        //获取上传文件的原名
        String originalFilename = file.getOriginalFilename();
        //获取文件的字节大小
        long size = file.getSize();
       System.out.println(originalFilename+"\t"+size);
       //上传文件保存到目标文件中
       file.transferTo(new File(attachFilePath+File.separator+originalFilename));


        return "success";
    }

    @RequestMapping("/saveAuthor")
    @ResponseBody
    public String saveAuthor(HttpServletRequest request,
                             @ModelAttribute Author author) throws Exception {
        System.out.println(author.getUserName());
        System.out.println(author.getAge());
        if(author.getImage().isEmpty()){
            return "error";
        }
        //获取上传文件的原名
        String originalFilename = author.getImage().getOriginalFilename();
        //保存路径  可配置在properties文件里面
        String attachFilePath ="D:/AttachFiles/";
        author.getImage().transferTo(new File(attachFilePath+File.separator+originalFilename));
        return "success";
    }
}

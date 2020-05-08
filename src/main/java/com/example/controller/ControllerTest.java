package com.example.controller;

import com.example.module.entity.WebSiteRuleEntity;
import com.example.processor.TestProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin // 解决跨域请求
@RequestMapping("test")
public class ControllerTest {

    @Autowired
    private TestProcessor testProcessor;
    @RequestMapping("test")
    public String test(){
        return "success";
    }
    @RequestMapping("website")
    public String website(@RequestBody WebSiteRuleEntity webSiteRuleEntity) throws InterruptedException {

        testProcessor.testWebSite(webSiteRuleEntity);
//        servletContext.setAttribute("webSiteRuleEntity",webSiteRuleEntity);
//        session.setAttribute("webSiteRuleEntity",webSiteRuleEntity);
        return "success";
    }
}

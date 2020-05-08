package com.example.controller;

import cn.hutool.crypto.digest.MD5;
import com.example.module.entity.WebSiteRuleEntity;
import com.example.service.WebSiteRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName WebSiteRuleController
 * @Description TODO
 * @Author miaoyi
 * @Date 2020-04-27 16:57
 * @Version 1.0
 **/
@RestController
@CrossOrigin // 解决跨域请求
@RequestMapping("website")
public class WebSiteRuleController {

    @Autowired
    private WebSiteRuleService webSiteRuleService;

    @RequestMapping("findAll")
    public List<WebSiteRuleEntity> findAll(){
        return webSiteRuleService.findAll();
    }
    @RequestMapping("save")
    public String save(@RequestBody WebSiteRuleEntity webSiteRuleEntity){
        webSiteRuleEntity.setSeedMd5(MD5.create().digestHex16(webSiteRuleEntity.getSeed()));
        webSiteRuleService.save(webSiteRuleEntity);
        return "ok";
    }
}

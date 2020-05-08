package com.example.service;

import com.example.module.entity.WebSiteRuleEntity;

import java.util.List;

/**
 * @ClassName WebSiteRuleService
 * @Description TODO
 * @Author miaoyi
 * @Date 2020-04-27 17:13
 * @Version 1.0
 **/

public interface WebSiteRuleService {
    List<WebSiteRuleEntity> findAll();

    void save(WebSiteRuleEntity webSiteRuleEntity);
}

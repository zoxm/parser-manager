package com.example.service.impl;

import cn.hutool.crypto.digest.MD5;
import com.example.module.entity.WebSiteRuleEntity;
import com.example.repository.WebSiteRuleRepository;
import com.example.service.WebSiteRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName WebSiteRuleService
 * @Description TODO
 * @Author miaoyi
 * @Date 2020-04-27 17:13
 * @Version 1.0
 **/
@Service
public class WebSiteRuleServiceImpl implements WebSiteRuleService {


    @Autowired
    private WebSiteRuleRepository webSiteRuleRepository;
    public List<WebSiteRuleEntity> findAll(){
      return webSiteRuleRepository.findAll();
    }

    @Override
    public void save(WebSiteRuleEntity webSiteRuleEntity) {
        String digestHex16 = MD5.create().digestHex16(webSiteRuleEntity.getSeed());
        if (webSiteRuleRepository.findBySeedMd5(digestHex16).isPresent()){
            // 如果已经存在 就修改
            return ;
        }
        webSiteRuleRepository.saveAndFlush(webSiteRuleEntity);
    }


}

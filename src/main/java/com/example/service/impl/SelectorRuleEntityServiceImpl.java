package com.example.service.impl;

import cn.hutool.log.StaticLog;
import com.example.module.entity.SelectorRuleEntity;
import com.example.repository.SelectorRuleEntityRepository;
import com.example.service.SelectorRuleEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


/**
 * @ClassName SelectorRuleEntityService
 * @Description TODO
 * @Author miaoyi
 * @Date 2020-04-21 9:08
 * @Version 1.0
 **/

@Service
public class SelectorRuleEntityServiceImpl implements SelectorRuleEntityService {
    @Autowired
    private SelectorRuleEntityRepository selectorRuleEntityRepository;
    @Override
    public void save(SelectorRuleEntity selectorRuleEntity) {
        Optional<SelectorRuleEntity> byTableName = selectorRuleEntityRepository.findByTableName(selectorRuleEntity.getTableName());
        if (byTableName.isPresent()) {
            StaticLog.info("重复规则 ：{}",byTableName.get().getTableName());
            return;
        }
        selectorRuleEntityRepository.saveAndFlush(selectorRuleEntity);
    }
}

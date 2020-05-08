package com.example.service.impl;

import com.example.module.entity.FieldRuleEntity;
import com.example.repository.FieldRuleServiceRepository;
import com.example.service.FieldRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName FieldRuleServiceImpl
 * @Description TODO
 * @Author miaoyi
 * @Date 2020-04-29 9:10
 * @Version 1.0
 **/
@Service
public class FieldRuleServiceImpl implements FieldRuleService {
    @Autowired
    private FieldRuleServiceRepository fieldRuleServiceRepository;
    @Override
    public void save(FieldRuleEntity fieldRuleEntity) {
        if (fieldRuleServiceRepository.findBySeedMd5(fieldRuleEntity.getSeedMd5()).isPresent()){
            // 如果已经存在 就修改
            return ;
        }
        fieldRuleServiceRepository.saveAndFlush(fieldRuleEntity);
    }
}

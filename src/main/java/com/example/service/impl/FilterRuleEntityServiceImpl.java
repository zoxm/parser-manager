package com.example.service.impl;

import cn.hutool.log.StaticLog;
import com.example.module.entity.FilterRuleEntity;
import com.example.repository.FilterRuleEntityRepository;
import com.example.service.FilterRuleEntityService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @ClassName FilterRuleEntityServiceImpl
 * @Description TODO
 * @Author miaoyi
 * @Date 2020-04-21 9:11
 * @Version 1.0
 **/
@Service
public class FilterRuleEntityServiceImpl implements FilterRuleEntityService {
    @Autowired
    private FilterRuleEntityRepository filterRuleEntityRepository;
    /*
     * 功能描述: <br>
     * 〈通过类型查询所有的规则〉
     * @Param: [type]
     * @Return: java.util.List<com.example.module.entity.FilterRuleEntity>
     * @Author: miaoyi
     * @Date: 2020-04-21 9:15
     */
//    @Override
//    public List<FilterRuleEntity> findFilterRuleEntitiesByType(@NonNull String type) {
//        List<FilterRuleEntity> filterRuleEntitiesByType = filterRuleEntityRepository.findFilterRuleEntitiesByType( type);
//        return filterRuleEntitiesByType;
//    }

    @Override
    public void save(FilterRuleEntity filterRuleEntity) {
        Optional<FilterRuleEntity> byTableName = filterRuleEntityRepository.findByTableName(filterRuleEntity.getTableName());
        if (byTableName.isPresent()){
            StaticLog.info("重复规则：{}",byTableName.get().getTableName());
            return;
        }
        filterRuleEntityRepository.saveAndFlush(filterRuleEntity);
    }

    @Override
    public String filterRules(String tableName,String htmlString) {

        if ("location".equals(tableName)){
            return htmlString.replace("详细地址会前通知","").replace("周边酒店预订","");
        }

        if ("time".equals(tableName)){
            return htmlString.replace("至", "").replace("结束", "");
        }
        return htmlString;
    }
}

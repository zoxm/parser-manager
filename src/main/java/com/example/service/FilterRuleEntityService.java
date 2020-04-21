package com.example.service;

import com.example.module.entity.FilterRuleEntity;

/**
 * @ClassName FilterRuleEntityService
 * @Description TODO
 * @Author miaoyi
 * @Date 2020-04-21 9:08
 * @Version 1.0
 **/

public interface FilterRuleEntityService {
//    List<FilterRuleEntity> findFilterRuleEntitiesByType(@NonNull String type);
    void save(FilterRuleEntity filterRuleEntity);
    String filterRules(String tableName,String htmlString);
}

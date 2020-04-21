package com.example.repository;

import com.example.module.entity.SelectorRuleEntity;
import com.example.repository.base.BaseRepository;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

/**
 * @ClassName UrlRepository
 * @Description TODO
 * @Author miaoyi
 * @Date 2020-03-21 13:07
 * @Version 1.0
 **/

public interface SelectorRuleEntityRepository extends BaseRepository<SelectorRuleEntity,Integer>, JpaSpecificationExecutor<SelectorRuleEntity> {
    List<SelectorRuleEntity> findSelectorRuleEntitiesByType(@NonNull String type);

    Optional<SelectorRuleEntity> findByTableName(@NonNull String tableName);
}

package com.example.repository;

import com.example.module.entity.FilterRuleEntity;
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

public interface FilterRuleEntityRepository extends BaseRepository<FilterRuleEntity,Integer>, JpaSpecificationExecutor<FilterRuleEntity> {

    List<FilterRuleEntity> findFilterRuleEntitiesByType(@NonNull String type);
//    FilterRuleEntity findFilterRuleEntitiesByTableName(@NonNull String tableName);
Optional<FilterRuleEntity> findByTableName(@NonNull String tableName);

}

package com.example.repository;

import com.example.module.entity.FieldRuleEntity;
import com.example.repository.base.BaseRepository;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

/**
 * @ClassName FieldRuleServiceRepository
 * @Description TODO
 * @Author miaoyi
 * @Date 2020-04-29 9:11
 * @Version 1.0
 **/

public interface FieldRuleServiceRepository  extends BaseRepository<FieldRuleEntity,Integer>, JpaSpecificationExecutor<FieldRuleEntity> {
    Optional<FieldRuleEntity> findBySeedMd5(@NonNull String seedMd5);
}

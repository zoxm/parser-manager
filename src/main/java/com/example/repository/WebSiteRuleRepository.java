package com.example.repository;

import com.example.module.entity.WebSiteRuleEntity;
import com.example.repository.base.BaseRepository;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;


/**
 * @ClassName WebSiteRuleRepository
 * @Description TODO
 * @Author miaoyi
 * @Date 2020-03-21 13:07
 * @Version 1.0
 **/

public interface WebSiteRuleRepository extends BaseRepository<WebSiteRuleEntity,Integer>, JpaSpecificationExecutor<WebSiteRuleEntity> {
    Optional<WebSiteRuleEntity> findBySeedMd5(@NonNull String seedMd5);
}

package com.example.repository;

import com.example.module.entity.MeettingEntity;
import com.example.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.lang.NonNull;

import java.util.Optional;

/**
 * @ClassName UrlEntityRepository
 * @Description TODO
 * @Author miaoyi
 * @Date 2020-03-21 13:07
 * @Version 1.0
 **/

public interface MeettingEntityRepository extends BaseRepository<MeettingEntity,Integer>, JpaSpecificationExecutor<MeettingEntity> {
    @NonNull
    Optional<MeettingEntity> findByName(@NonNull String name);
    @NonNull
    Optional<MeettingEntity> findByUrl(@NonNull String url);
}

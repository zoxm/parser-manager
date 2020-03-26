package com.example.repository;

import com.example.module.entity.UrlEntity;
import com.example.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


/**
 * @ClassName UrlEntityRepository
 * @Description TODO
 * @Author miaoyi
 * @Date 2020-03-21 13:07
 * @Version 1.0
 **/

public interface UrlEntityRepository extends BaseRepository<UrlEntity,Integer>, JpaSpecificationExecutor<UrlEntity> {
}

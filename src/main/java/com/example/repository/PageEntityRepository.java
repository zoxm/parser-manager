package com.example.repository;

import com.example.module.entity.PageEntity;
import com.example.repository.base.BaseRepository;
import lombok.NonNull;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UrlRepository
 * @Description TODO
 * @Author miaoyi
 * @Date 2020-03-21 13:07
 * @Version 1.0
 **/

public interface PageEntityRepository extends BaseRepository<PageEntity,Integer>, JpaSpecificationExecutor<PageEntity> {

//    List<PageEntity> findAllByFlag(@NonNull String flag);

    List<PageEntity> findPageEntitiesByFlag(/*@PageableDefault(value = 15, sort = { "id" }, direction = Sort.Direction.DESC)*/ Pageable pageable, @NonNull String flag);

    @Query(" select count(p.id) from PageEntity p where p.flag = ?1")
    Integer findPageEntityCountByFlag(String flag);


}

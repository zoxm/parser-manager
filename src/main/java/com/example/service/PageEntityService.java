package com.example.service;

import com.example.module.entity.PageEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;

import java.util.List;

/**
 * @ClassName PageEntityService
 * @Description TODO
 * @Author miaoyi
 * @Date 2020-03-24 17:09
 * @Version 1.0
 **/

public interface PageEntityService {

//    List<PageEntity> findAllByFlag(Integer page ,String flag);
    List<PageEntity> findPageEntitiesByFlag(Integer page,String flag);
    Integer findPageEntityCountByFlag(String flag);
    int updatePageEntityByUrlId(String flag,String urlId);
}

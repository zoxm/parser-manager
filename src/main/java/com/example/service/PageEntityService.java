package com.example.service;

import com.example.module.entity.PageEntity;

import java.util.List;

/**
 * @ClassName PageEntityService
 * @Description TODO
 * @Author miaoyi
 * @Date 2020-03-24 17:09
 * @Version 1.0
 **/

public interface PageEntityService {

    List<PageEntity> findAllByFlag(String flag);
}

package com.example.service;

import com.example.module.entity.UrlEntity;

import java.util.List;

/**
 * @ClassName MeettingService
 * @Description TODO
 * @Author miaoyi
 * @Date 2020-03-22 21:07
 * @Version 1.0
 **/

public interface UrlService {

    List<UrlEntity> findAll();
}

package com.example.service;

import com.example.module.entity.MeettingEntity;

import java.util.List;

/**
 * @ClassName MeettingService
 * @Description TODO
 * @Author miaoyi
 * @Date 2020-03-22 21:07
 * @Version 1.0
 **/

public interface MeettingService {

    List<MeettingEntity> findAll();
}

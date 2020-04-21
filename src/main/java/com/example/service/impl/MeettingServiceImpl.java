package com.example.service.impl;

import cn.hutool.log.StaticLog;
import com.example.module.entity.MeettingEntity;
import com.example.repository.MeettingEntityRepository;
import com.example.repository.PageEntityRepository;
import com.example.service.MeettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @ClassName MeettingServiceImpl
 * @Description TODO
 * @Author miaoyi
 * @Date 2020-03-22 21:07
 * @Version 1.0
 **/

@Service
public class MeettingServiceImpl implements MeettingService {
    @Autowired
    private MeettingEntityRepository meettingEntityRepository;

    @Autowired
    private PageEntityRepository pageEntityRepository;

    @Override
    public List<MeettingEntity> findAll() {
        List<MeettingEntity> all = meettingEntityRepository.findAll();
        return all;
    }
    @Override
    public void save(MeettingEntity meettingEntity) {

        Optional<MeettingEntity> byUrl = meettingEntityRepository.findByUrl(meettingEntity.getUrl());
        if (byUrl.isPresent()){
            StaticLog.info("重复会议：{}",meettingEntity.getUrl());
            return;
        }
        StaticLog.info("持久化：{}",meettingEntity.getUrl());
        meettingEntityRepository.saveAndFlush(meettingEntity);

        // 刷新已经解析标记

    }
}

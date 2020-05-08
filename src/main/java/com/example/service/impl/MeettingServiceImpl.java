package com.example.service.impl;

import cn.hutool.log.StaticLog;
import com.example.module.entity.MeettingEntity;
import com.example.repository.MeettingRepository;
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
    private MeettingRepository meettingRepository;


    @Override
    public List<MeettingEntity> findAll() {
        List<MeettingEntity> all = meettingRepository.findAll();
        return all;
    }
    @Override
    public void save(MeettingEntity meettingEntity) {
//        System.out.println("meettingRepository\t"+this.meettingRepository);
        Optional<MeettingEntity> byUrl = this.meettingRepository.findByUrl(meettingEntity.getUrl());
        if (byUrl.isPresent()){
            StaticLog.info("duplicated URL：{}",meettingEntity.getUrl());
            return;
        }
//        StaticLog.info("repository save：{} ",meettingEntity.getUrl() );
        meettingRepository.saveAndFlush(meettingEntity);

        // 刷新已经解析标记

    }
}

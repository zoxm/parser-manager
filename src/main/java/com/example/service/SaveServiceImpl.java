package com.example.service;

import com.example.module.entity.MeettingEntity;
import com.example.repository.MeettingEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

/**
 * @ClassName SaveServiceImpl
 * @Description TODO
 * @Author miaoyi
 * @Date 2020-03-21 13:04
 * @Version 1.0
 **/
@Service
public class SaveServiceImpl implements SaveService {

    @Autowired
    private MeettingEntityRepository meettingEntityRepository;
    @Override
    public void save(MeettingEntity meettingEntity) {


        Optional<MeettingEntity> byName = meettingEntityRepository.findByName(meettingEntity.getName());
        if (byName.isPresent()){
            return;
        }
        meettingEntity.setId(UUID.randomUUID().toString());
        meettingEntityRepository.saveAndFlush(meettingEntity);
    }
}

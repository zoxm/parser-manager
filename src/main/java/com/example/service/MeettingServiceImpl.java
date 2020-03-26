package com.example.service;

import com.example.module.entity.MeettingEntity;
import com.example.repository.MeettingEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<MeettingEntity> findAll() {
        List<MeettingEntity> all = meettingEntityRepository.findAll();
        return all;
    }
}

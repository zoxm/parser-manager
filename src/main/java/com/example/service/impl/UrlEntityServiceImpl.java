package com.example.service.impl;

import com.example.module.entity.UrlEntity;
import com.example.repository.UrlEntityRepository;
import com.example.service.UrlEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UrlEntityServiceImpl
 * @Description TODO
 * @Author miaoyi
 * @Date 2020-03-22 21:13
 * @Version 1.0
 **/
@Service
public class UrlEntityServiceImpl implements UrlEntityService {
    @Autowired
    private UrlEntityRepository urlEntityRepository;


    @Override
    public List<UrlEntity> findAll() {
        List<UrlEntity> all = urlEntityRepository.findAll();
        return all;
    }
}

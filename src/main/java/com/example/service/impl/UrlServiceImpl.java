package com.example.service.impl;

import com.example.module.entity.UrlEntity;
import com.example.repository.UrlRepository;
import com.example.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UrlServiceImpl
 * @Description TODO
 * @Author miaoyi
 * @Date 2020-03-22 21:13
 * @Version 1.0
 **/
@Service
public class UrlServiceImpl implements UrlService {
    @Autowired
    private UrlRepository urlRepository;


    @Override
    public List<UrlEntity> findAll() {
        List<UrlEntity> all = urlRepository.findAll();
        return all;
    }
}

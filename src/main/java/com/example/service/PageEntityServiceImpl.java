package com.example.service;

import com.example.module.entity.PageEntity;
import com.example.repository.PageEntityRepository;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName PageEntityServiceImpl
 * @Description TODO
 * @Author miaoyi
 * @Date 2020-03-24 17:09
 * @Version 1.0
 **/

@Service
public class PageEntityServiceImpl implements PageEntityService {

    @Autowired
    private PageEntityRepository pageEntityRepository;
    @Override
    public List<PageEntity> findAllByFlag(String flag) {
        List<PageEntity> allByFlag = pageEntityRepository.findAllByFlag(flag);
        return allByFlag;
    }
}

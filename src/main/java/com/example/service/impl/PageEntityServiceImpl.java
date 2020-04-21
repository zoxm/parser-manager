package com.example.service.impl;

import com.example.module.entity.PageEntity;
import com.example.repository.PageEntityRepository;
import com.example.service.PageEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
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
    public Integer findPageEntityCountByFlag(String flag) {
        return pageEntityRepository.findPageEntityCountByFlag(flag);
    }

    @Override
    public int updatePageEntityByUrlId(String flag, String urlId) {
        int i = pageEntityRepository.updatePageEntityByUrlId(flag, urlId);
        return i;
    }

    @Override
    public List<PageEntity> findPageEntitiesByFlag(Integer page,String flag) {
        PageRequest of = PageRequest.of(page, 16);
        List<PageEntity> pageEntitiesByFlag = pageEntityRepository.findPageEntitiesByFlag(of, flag);
        return pageEntitiesByFlag;
    }
}

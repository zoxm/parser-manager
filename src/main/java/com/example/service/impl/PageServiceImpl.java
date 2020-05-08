package com.example.service.impl;

import cn.hutool.log.StaticLog;
import com.example.module.entity.PageEntity;
import com.example.repository.PageRepository;
import com.example.service.PageService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

/**
 * @ClassName PageServiceImpl
 * @Description TODO
 * @Author miaoyi
 * @Date 2020-03-24 17:09
 * @Version 1.0
 **/

@Service
public class PageServiceImpl implements PageService {
    @Autowired
    private PageRepository pageRepository;

    @Override
    public void savePageEntity(PageEntity pageEntity){

        // 查重
        @NonNull Optional<PageEntity> byMd5 = pageRepository.findByMd5(pageEntity.getMd5());
        if (byMd5.isPresent()){
            StaticLog.info("page document repeat:  {}  ", pageEntity.getUrl());
            return ;
        }
        pageRepository.saveAndFlush(pageEntity);
        StaticLog.info("page document save:  {}  ", pageEntity.getUrl());
    }
//    @Autowired
//    private PageRepository pageRepository;
//
//
//
//    @Override
//    public Integer findPageEntityCountByFlag(String flag) {
//        return pageRepository.findPageEntityCountByFlag(flag);
//    }
//
//    @Override
//    public int updatePageEntityByUrlId(String flag, String urlId) {
//        int i = pageRepository.updatePageEntityByUrlId(flag, urlId);
//        return i;
//    }
//
//    @Override
//    public List<PageEntity> findPageEntitiesByFlag(Integer page, String flag) {
//        PageRequest of = PageRequest.of(page, 16);
//        List<PageEntity> pageEntitiesByFlag = pageRepository.findPageEntitiesByFlag(of, flag);
//        return pageEntitiesByFlag;
//    }
}

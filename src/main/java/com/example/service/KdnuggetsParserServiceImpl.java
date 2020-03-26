package com.example.service;

import cn.hutool.log.StaticLog;
import com.example.module.entity.MeettingEntity;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName KdnuggetsParserServiceImpl
 * @Description TODO
 * @Author miaoyi
 * @Date 2020-03-21 12:05
 * @Version 1.0
 **/

@Service
public class KdnuggetsParserServiceImpl implements KdnuggetsParserService {

    @Autowired
    private SaveService saveService;

    @Override
    public void parser(Document document) {

        Elements pages = document.getElementsByClass("page_content");
        pages.forEach(page->{
            StaticLog.info("page {}  ", page.text());
//            Elements uls = page.getElementsByTag("ul");
//            uls.forEach(ul ->{
//                StaticLog.info("会议详情 {}  ", ul.text());
//                Elements lis = ul.getElementsByTag("li");
//                lis.forEach(li->{
//                    StaticLog.info("会议详情 {}  ", li.text());
//                });
//            });
        });

    }
}

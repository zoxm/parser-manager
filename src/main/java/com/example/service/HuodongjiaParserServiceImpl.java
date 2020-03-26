package com.example.service;

import cn.hutool.log.StaticLog;
import com.example.module.entity.MeettingEntity;
import com.example.module.entity.PageEntity;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName HuodongjiaParserServiceImpl
 * @Description TODO
 * @Author miaoyi
 * @Date 2020-03-21 12:05
 * @Version 1.0
 **/

@Service
public class HuodongjiaParserServiceImpl implements HuodongjiaParserService {

    @Autowired
    private SaveService saveService;

    @Override
    public void parser(PageEntity pageEntity,Document document) {
        Elements elements = document.getElementsByTag("p");
        MeettingEntity meettingEntity = new MeettingEntity();
        elements.forEach(element -> {
            if (element.text().contains("会议时间：")) {
//                StaticLog.info("{}  ", element.text());
                meettingEntity.setTime(element.text());
            }
            if (element.text().contains("会议地点：")) {
                StaticLog.info("{}  ", element.text());
                meettingEntity.setLocation(element.text());
            }
            if (element.text().contains("会议规模：")) {
//                StaticLog.info("{}  ", element.text());
                meettingEntity.setScale(element.text());
            }
            if (element.text().contains("主办单位：")) {
                meettingEntity.setCompany(element.text());
            }



        });
        Elements eventNames = document.getElementsByClass("event_name");
        eventNames.forEach(name ->{
            Elements contens = name.getElementsByTag("a");
//            StaticLog.info("{}  ", contens.get(0).text());
            meettingEntity.setName(contens.get(0).text());
        });
        meettingEntity
                .setPageId(pageEntity.getId())
                .setUrl(pageEntity.getUrl());
        StaticLog.info("{}  ", meettingEntity.toString());
        saveService.save(meettingEntity);
    }
}

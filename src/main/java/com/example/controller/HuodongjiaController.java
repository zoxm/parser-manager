package com.example.controller;

import cn.hutool.log.StaticLog;
import com.example.module.entity.PageEntity;
import com.example.module.entity.UrlEntity;
import com.example.repository.PageEntityRepository;
import com.example.service.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.List;

/**
 * @ClassName HuoDongXingController
 * @Description TODO
 * @Author miaoyi
 * @Date 2020-03-13 12:51
 * @Version 1.0
 **/
@RestController
@RequestMapping("huodongjia")
public class HuodongjiaController {

    @Autowired
    private PageEntityService pageEntityService;
    @Autowired
    private HuodongjiaParserService huodongjiaParserService;


    private static final String URL = "https://www.huodongjia.com/";

    @RequestMapping("all")
    public String run() {

        StaticLog.info("parser-manager 解析开始 {}  ", "===============================");

        Integer count = pageEntityService.findPageEntityCountByFlag("no");

        Integer floor = (int) (Math.floor(count / 16));
        while ( floor >= 0 ) {
            floor --;
            try {
                // 读取
                List<PageEntity> pageEntityList = pageEntityService.findPageEntitiesByFlag(floor,"no");
                pageEntityList.forEach(pageEntity -> {
                    Document document = Jsoup.parse(pageEntity.getDocument());
                    StaticLog.info("parser-manager 解析 {}  {}", pageEntity.getUrl(),pageEntity.getFlag());
                    huodongjiaParserService.parser(pageEntity, document);
                });

                if ( floor < 0){
                    count = pageEntityService.findPageEntityCountByFlag("no");
                    floor = (int) (Math.floor(count / 16));
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return "网址：解析完毕";
    }
}

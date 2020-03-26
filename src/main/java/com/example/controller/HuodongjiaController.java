package com.example.controller;

import cn.hutool.log.StaticLog;
import com.example.module.entity.PageEntity;
import com.example.module.entity.UrlEntity;
import com.example.repository.PageEntityRepository;
import com.example.service.HuodongjiaParserService;
import com.example.service.MeettingService;
import com.example.service.RunService;
import com.example.service.UrlEntityService;
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
    private RunService runService;
    @Autowired
    private UrlEntityService urlEntityService;
    @Autowired
    private MeettingService meettingService;
    @Autowired
    private PageEntityRepository pageEntityRepository;
    @Autowired
    private HuodongjiaParserService huodongjiaParserService;


    private static final String URL = "https://www.huodongjia.com/";

    @RequestMapping("all")
    public String run() {
        // 读取
        List<PageEntity> pageEntityList = pageEntityRepository.findAllByFlag("no");

        pageEntityList.forEach(pageEntity -> {
            Document document = Jsoup.parse(pageEntity.getDocument());
            StaticLog.info("{}  ", pageEntity);
            huodongjiaParserService.parser(pageEntity,document);
        });

        return "网址：解析完毕";
    }
}

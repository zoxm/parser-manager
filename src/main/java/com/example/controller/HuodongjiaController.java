package com.example.controller;

import cn.hutool.log.StaticLog;
import com.example.module.entity.PageEntity;

import com.example.service.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
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
    private ParserService parserService;


    private static final String URL = "https://www.huodongjia.com/";

    @RequestMapping("all")
    public String run() throws InterruptedException {

        StaticLog.info("parser-manager 解析开始 {}  ", "===============================");

        Integer count = pageEntityService.findPageEntityCountByFlag("no");

        Integer floor = (int) (Math.floor(count / 16));


        while ( true ) {

            try {
                // 读取
                List<PageEntity> pageEntityList = pageEntityService.findPageEntitiesByFlag(floor,"no");
                StaticLog.info("pageEntityList size {}", pageEntityList.size());
                if (pageEntityList.size() == 0) {
                    Thread.sleep(3000000);
                }else {
                    pageEntityList.forEach(pageEntity -> {

                        Document document = Jsoup.parse(pageEntity.getDocument());
                        StaticLog.info("parser-manager 解析 {}  {}", pageEntity.getUrl(),pageEntity.getFlag());
                        parserService.parser(pageEntity, document);
                        // 修改 page 里面已经解析的标记
                        int res = pageEntityService.updatePageEntityByUrlId("yes", pageEntity.getUrlId());

                    });
                }
                floor --;

                if ( floor < 0){
                    count = pageEntityService.findPageEntityCountByFlag("no");
                    floor = (int) (Math.floor(count / 16));
                }
            }catch (Exception e){
                e.printStackTrace();
            }



        }
//        return "网址：解析完毕";
    }
    @RequestMapping("allX")
    public String runX()  {

        StaticLog.info("parser-manager 解析开始 {}  ", "================== =============");

        Integer count = pageEntityService.findPageEntityCountByFlag("no");

        Integer floor = (int) (Math.floor(count / 16));
        while ( true ) {
            try {
                // 读取
                List<PageEntity> pageEntityList = pageEntityService.findPageEntitiesByFlag(floor,"no");
                StaticLog.info("pageEntityList size {}", pageEntityList.size());
                if (pageEntityList.size() == 0) {
                    Thread.sleep(3000000);
                }else {
                    pageEntityList.forEach(pageEntity -> {
                        Document document = Jsoup.parse(pageEntity.getDocument());
                        StaticLog.info("parser-manager 解析 {}  {}", pageEntity.getUrl(),pageEntity.getFlag());
                        try {
                            parserService.parser(pageEntity,document, "https://www.huodongjia.com/");
                        } catch (NoSuchFieldException e) {
                            e.printStackTrace();
                        } catch (IntrospectionException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                        // 修改 page 里面已经解析的标记
                        int res = pageEntityService.updatePageEntityByUrlId("yes", pageEntity.getUrlId());

                    });
                }
                floor --;

                if ( floor < 0){
                    count = pageEntityService.findPageEntityCountByFlag("no");
                    floor = (int) (Math.floor(count / 16));
                }
            }catch (Exception e){
                e.printStackTrace();
            }



        }
//        return "网址：解析完毕";
    }
}

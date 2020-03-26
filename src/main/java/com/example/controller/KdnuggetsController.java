package com.example.controller;

import cn.hutool.log.StaticLog;
import com.example.service.HuodongjiaParserService;
import com.example.service.KdnuggetsParserService;
import com.example.service.RunService;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HuoDongXingController
 * @Description TODO
 * @Author miaoyi
 * @Date 2020-03-13 12:51
 * @Version 1.0
 **/
@RestController
@RequestMapping("kdnuggets")
public class KdnuggetsController {

    @Autowired
    private RunService runService;

    @Autowired
    private KdnuggetsParserService kdnuggetsParserService;

    private static final String URL = "https://www.kdnuggets.com/meetings";

    @RequestMapping("{indexUrl}")
    public String run(@PathVariable("indexUrl")String indexUrl){
        // 读取
        System.out.println("采集url=========================================="+URL + indexUrl);
        Document document = runService.getDocument(URL + indexUrl);
        StaticLog.info("{}  ", document);

        // 解析和存储
//        kdnuggetsParserService.parser(document);
        return "网址："+URL+indexUrl+"/ "+"采集完毕";
    }
}

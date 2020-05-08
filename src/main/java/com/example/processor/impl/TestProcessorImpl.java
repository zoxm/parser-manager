package com.example.processor.impl;

import com.example.module.entity.WebSiteRuleEntity;
import com.example.pipeline.ConsolePipeline;
import com.example.pipeline.TestPipeline;
import com.example.processor.TestProcessor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;

import javax.servlet.ServletContext;

/**
 * @ClassName TestProcessorImpl
 * @Description TODO
 * @Author miaoyi
 * @Date 2020-04-28 15:55
 * @Version 1.0
 **/
@Component
@Data
public class TestProcessorImpl implements TestProcessor {

    @Autowired
    private ServletContext servletContext;
    private Site site = Site.me()
            .setRetryTimes(3)
            .setSleepTime(1000)
            .setTimeOut(10000);

    private static WebSiteRuleEntity webSiteRuleEntity;

    @Override
    public void testWebSite(WebSiteRuleEntity webSiteRuleEntity) throws InterruptedException {
        this.webSiteRuleEntity = webSiteRuleEntity;

        TestProcessorImpl testProcessor = new TestProcessorImpl();
        Spider spider = Spider.create(testProcessor);
        spider

                // 种子
                .addUrl(webSiteRuleEntity.getSeed())
                // 存储任务
                .addPipeline(new ConsolePipeline())
//                .addPipeline(new ExcelPipeline("/data/webmagic/"))
//                .setExecutorService()
                // 线程
                .thread(1)


                // 开始
                .run();
    }

    @Override
    public void process(Page page) {
        System.out.println(webSiteRuleEntity);
        page.addTargetRequests(page.getHtml()
                .xpath(webSiteRuleEntity.getListXpathRule())
                .regex(webSiteRuleEntity.getListRegexRule())
                .all());
        page.addTargetRequests(page.getHtml()
                .xpath(webSiteRuleEntity.getDetailXpathRule())
                .regex(webSiteRuleEntity.getDetailRegexRule())
                .all());
        page.putField("url", page.getUrl());
    }

    @Override
    public Site getSite() {
        return site;
    }
}

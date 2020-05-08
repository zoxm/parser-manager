package com.example.processor.impl;

import com.example.module.entity.WebSiteRuleEntity;
import com.example.pipeline.ConsolePipeline;
import com.example.processor.BaseProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;

/**
 * @ClassName BaseProcessorImpl
 * @Description TODO
 * @Author miaoyi
 * @Date 2020-04-27 9:41
 * @Version 1.0
 **/
@Component
public class BaseProcessorImpl implements BaseProcessor {
    private Site site = Site.me()
            .setRetryTimes(3)
            .setSleepTime(1000)
            .setTimeOut(10000);
    @Override
    public String parser(Page page, String xpathString, String regexString) {
        return page.getHtml().xpath(xpathString).regex(regexString).toString();
    }

    @Override
    public String replace(String oldString, String replacedA, String replaceB) {
        return oldString.replace(replacedA,replaceB);
    }

    @Autowired
    private  BaseProcessor processor;
    @Autowired
    private ConsolePipeline consolePipeline;
    @Override
    public void run(WebSiteRuleEntity webSiteRuleEntity) {
        Spider.create(processor)
                // 种子
                .addUrl("https://www.huodongjia.com/business")
                // 存储任务
                .addPipeline(consolePipeline)
                // 线程
                .thread(1)
                // 开始
                .run();
    }

    @Override
    public void process(Page page) {
        //
        page.addTargetRequests(page.getHtml()
                .xpath("//h3/a/@abs:href | //div[@class='condition']/a/@abs:href | //div[@class='pagination']/ul/li/a/@abs:href | //div[@class='tags']/a/@abs:href")
                .all());
        page.putField("name",page.getHtml().xpath("//h1[@class='event_name']/a/text()").get());
        page.putField("img",page.getHtml().xpath("//td[@style='width: 308px']/a/img/@src").get()+"");
        page.putField("url",page.getUrl());
        page.putField("time",page.getHtml().xpath("//table[@class='event_infomation']/tbody/tr/td[2]/p[1]/allText()").get()+"");// 会议时间
        page.putField("location",page.getHtml().xpath("//table[@class='event_infomation']/tbody/tr/td[2]/p[2]/allText()").get()+"");// 会议地点
        page.putField("scale",page.getHtml().xpath("//table[@class='event_infomation']/tbody/tr/td[2]/p[3]/allText()").regex(".*会议规模.*").get()+"");// 会议规模
        page.putField("company",page.getHtml().xpath("//table[@class='event_infomation']/tbody/tr/td[2]/p[4]/allText()|//table[@class='event_infomation']/tbody/tr/td[2]/p[3]/tidyText()").regex(".*主办单位.*").get()+"");// 主办单位
        page.putField("content",page.getHtml().xpath("//div[@id='meeting_1']/div[@class='meeting_content']/div[@class='s_tag  act ']/div[@class='new_content']/div[@class='con_box']/tidyText()").get()+"");// 主要内容
        page.putField("introduce",page.getHtml().xpath("//div[@id='meeting_1']/div[@class='meeting_content']/div[@class='s_tag']/tidyText()").get()+"");// 主办方介绍
        page.putField("schedule",page.getHtml().xpath("//div[@id='meeting_2']/div[@class='meeting_content']/tidyText()").get()+"");// 会议日程
        page.putField("guest",page.getHtml().xpath("//div[@id='meeting_3']/div[@class='meeting_content']/tidyText()").get()+"");// 会议嘉宾
        page.putField("guide",page.getHtml().xpath("//div[@id='meeting_4']/div[@class='meeting_content']/tidyText()").get()+"");// 参会指南
        page.putField("tag",page.getHtml().xpath("//div[@class='tags']/a/allText()").all());// 标签
        if (page.getResultItems().get("name") == null || page.getResultItems().get("url") == null){
            page.setSkip(true);
        }
    }

    @Override
    public Site getSite() {
        return site;
    }

}

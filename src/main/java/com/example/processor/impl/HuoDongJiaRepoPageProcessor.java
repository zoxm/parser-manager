package com.example.processor.impl;

import lombok.Data;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;


/**
 * @author code4crafter@gmail.com <br>
 * @since 0.3.2
 */
@Data
@Service
public class HuoDongJiaRepoPageProcessor implements PageProcessor {

    private Site site = Site.me()
            .setRetryTimes(3)
            .setSleepTime(1000)
            .setTimeOut(10000);

    private void processed(Page page){

    }

    @Override
    public void process(Page page) {
        // 判断是否是列表页
        // 如果是详情页
        if (page.getUrl().toString().contains("/event-")){
            // 如果是详情页
            // 采集代码逻辑
//            page.putField("document",page.getHtml());
//            page.putField("url",page.getUrl().toString());
            page.putField("name",page.getHtml().xpath("//h1[@class='event_name']/a/text()").get());
//            page.putField("name2",page.getHtml().xpath("//td[@style='width: 308px']/a/img/@alt").get());
            page.putField("img",page.getHtml().xpath("//td[@style='width: 308px']/a/img/@src").get());
            page.putField("url",page.getUrl());
            page.putField("time",page.getHtml().xpath("//table[@class='event_infomation']/tbody/tr/td[2]/p[1]/allText()").get());// 会议时间
            page.putField("location",page.getHtml().xpath("//table[@class='event_infomation']/tbody/tr/td[2]/p[2]/allText()").get());// 会议地点
            page.putField("scale",page.getHtml().xpath("//table[@class='event_infomation']/tbody/tr/td[2]/p[3]/allText()").regex(".*会议规模.*").get());// 会议规模
            page.putField("company",page.getHtml().xpath("//table[@class='event_infomation']/tbody/tr/td[2]/p[4]/allText()|//table[@class='event_infomation']/tbody/tr/td[2]/p[3]/allText()").regex(".*主办单位.*").get());// 主办单位
//            page.putField("content",page.getHtml().xpath("//table[@class='event_infomation']/tbody/tr/td[2]/p[4]/tidyText()").get());//会议正文
//            page.putField("guide",page.getHtml().xpath("//table[@class='event_infomation']/tbody/tr/td[2]/p[4]/tidyText()").get());// 参会指南

        } else if (!page.getUrl().toString().contains("/event-")){
            // 如果是列表页
            // 将 复合条件的详情页加入备爬队列
            page.addTargetRequests(page.getHtml().xpath("//h3/a/@abs:href").all());

            // 将 复合条件的列表页加入备爬队列
            page.addTargetRequests(page.getHtml().xpath("//div[@class='condition']/a/@abs:href").all());
            // 如果存在翻页
            if (page.getHtml().xpath("//div[@class='pagination']/ul/li//a/@abs:href").match()){
                page.addTargetRequests(page.getHtml().xpath("//div[@class='pagination']/ul/li//a/@abs:href").all());
            }
            page.setSkip(true);
        }else {

            // 如果什么都不是  直接丢弃
            page.setSkip(true);

        }

    }


}

package com.example.service;

import cn.hutool.log.StaticLog;
import com.example.module.entity.MeettingEntity;
import com.example.module.entity.PageEntity;
import com.example.repository.MeettingEntityRepository;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
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
    private MeettingService meettingService;

    @Override
    public void parser(PageEntity pageEntity, Document document) {

        /*
         *
         * 创建会议对象
         * */
        MeettingEntity meettingEntity = new MeettingEntity();

        /*
         * 解析出会议的基本内容
         * */
        Elements elements = document.getElementsByTag("p");
        elements.forEach(element -> {
            if (element.text().contains("会议时间：")) {
//                StaticLog.info("{}  ", element.text());
                meettingEntity.setTime(element.text().replace("会议时间：", ""));
            }
            if (element.text().contains("会议地点：")) {
//                StaticLog.info("{}  ", element.text());
                meettingEntity.setLocation(element.text().replace("会议地点：", ""));
            }
            if (element.text().contains("会议规模：")) {
//                StaticLog.info("{}  ", element.text());
                meettingEntity.setScale(element.text().replace("会议规模：", ""));
            }
            if (element.text().contains("主办单位：")) {
                meettingEntity.setCompany(element.text().replace("主办单位：", ""));
            }
        });



        /*
         * 获取会议主题名
         * */
        Elements eventNames = document.getElementsByClass("event_name");
        eventNames.forEach(name -> {
            Elements contens = name.getElementsByTag("a");
            StaticLog.info(" name {}  ", contens.get(0).text());
            meettingEntity.setName(contens.get(0).text());
        });



        Elements contents = document.getElementsByClass("meeting_content");

        /*
         *
         * 会议通知
         * */
        if (contents.size() < 2){
            StaticLog.info("会议简略内容： {}  ",pageEntity.getUrl() );
        }else {
            Element meetingContent = contents.get(0);
            Elements imgs = meetingContent.getElementsByTag("img");
//        StaticLog.info("会议图片： {}  ", imgs.get(0).attr("src"));
            if (imgs.size() == 0 ){
                StaticLog.info("会议简略内容： {}  ",pageEntity.getUrl() );
            }else {
                meettingEntity.setImg(imgs.get(0).attr("src"));
            }


            Elements conBoxs = meetingContent.getElementsByClass("con_box");
//        StaticLog.info("会议正文：  {}  ", conBoxs.html());
            meettingEntity.setContent(conBoxs.html());

            Elements sTags = meetingContent.getElementsByClass("s_tag");
            if (sTags.size() !=0){
                Element element = sTags.get(1);
//        StaticLog.info("主办方介绍：  {}  ", element.html());
                meettingEntity.setIntroduce(element.html());
            }

            /*
             *
             * 会议日程
             * */

            meetingContent = contents.get(1);
            meettingEntity.setSchedule(meetingContent.html());
//        StaticLog.info("会议日程：  {}  ", meetingContent.html());

            /*
             *
             * 会议嘉宾
             * */
            meetingContent = contents.get(2);
            meettingEntity.setGuest(meetingContent.html());
//        StaticLog.info("会议嘉宾：  {}  ", meetingContent.html());
        }


        /*
         *
         * 保存当前解析的会议
         * */
        meettingEntity
                .setUrlId(pageEntity.getUrlId())
                .setUrl(pageEntity.getUrl());

        StaticLog.info("已经解析：{}  ", meettingEntity.getUrl());
        if (StringUtils.isEmpty(meettingEntity.getName())){
            return;
        }
        meettingService.save(meettingEntity);
    }
}

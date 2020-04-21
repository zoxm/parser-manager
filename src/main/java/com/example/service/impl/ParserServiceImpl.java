package com.example.service.impl;

import cn.hutool.log.StaticLog;
import com.example.module.entity.*;
import com.example.repository.FilterRuleEntityRepository;
import com.example.repository.SelectorRuleEntityRepository;
import com.example.service.FilterRuleEntityService;
import com.example.service.MeettingService;
import com.example.service.ParserService;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;

/**
 * @ClassName ParserServiceImpl
 * @Description TODO
 * @Author miaoyi
 * @Date 2020-03-21 12:05
 * @Version 1.0
 **/

@Service
public class ParserServiceImpl implements ParserService {

    @Autowired
    private MeettingService meettingService;
    @Autowired
    private FilterRuleEntityService filterRuleEntityService;
    @Autowired
    private SelectorRuleEntityRepository selectorRuleEntityRepository;
    @Autowired
    private FilterRuleEntityRepository filterRuleEntityRepository;

    @Override
    public void parser(PageEntity pageEntity, Document document) {

        /*
         *
         * 创建会议对象
         * */
        MeettingEntity meettingEntity = new MeettingEntity();

//        StaticLog.info("document: {}  ", document);

        /*
         *
         * 标签采集
         * */
        Elements containers = document.getElementsByClass("tags");
        meettingEntity.setTag("");
        if (containers.size() > 0) {
            containers.forEach(container -> {
                Elements as = container.getElementsByTag("a");
                if (as.size() > 0) {
                    as.forEach(a -> {
                        String text = a.text();
                        meettingEntity.setTag(meettingEntity.getTag() + text + " ");
                    });
                }
                StaticLog.info("会议标签 {}  ", meettingEntity.getTag());

            });
        }





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
                meettingEntity.setLocation(element.text().replace("会议地点：", "").replace("周边酒店预订", ""));
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
        if (contents.size() < 2) {
            StaticLog.info("会议简略内容： {}  ", pageEntity.getUrl());
        } else {
            Element meetingContent = contents.get(0);
            Elements imgs = meetingContent.getElementsByTag("img");
//        StaticLog.info("会议图片： {}  ", imgs.get(0).attr("src"));
            if (imgs.size() == 0) {
                StaticLog.info("会议简略内容： {}  ", pageEntity.getUrl());
            } else {
                meettingEntity.setImg(imgs.get(0).attr("src"));
            }


            Elements conBoxs = meetingContent.getElementsByClass("con_box");
//        StaticLog.info("会议正文：  {}  ", conBoxs.html());
            meettingEntity.setContent(conBoxs.html());

            Elements sTags = meetingContent.getElementsByClass("s_tag");
            if (sTags.size() != 0) {
                Element element = sTags.get(1);
//        StaticLog.info("主办方介绍：  {}  ", element.html());
                meettingEntity.setIntroduce(element.html());
            }

            /*
             *
             * 会议日程
             * */

            if (contents.size() >= 2) {
                meetingContent = contents.get(1);
                meettingEntity.setSchedule(meetingContent.html());
                //        StaticLog.info("会议日程：  {}  ", meetingContent.html());
            }



            /*
             *
             * 会议嘉宾
             * */
            if (contents.size() >= 3) {
                meetingContent = contents.get(2);
                meettingEntity.setGuest(meetingContent.html());
//        StaticLog.info("会议嘉宾：  {}  ", meetingContent.html());
            }


            /*
             *
             * 会议指南
             * */
            if (contents.size() >= 4) {
                meetingContent = contents.get(3);
                meettingEntity.setGuide(meetingContent.html());
//        StaticLog.info("会议指南：  {}  ", meetingContent.html());
            }

        }


        /*
         *
         * 保存当前解析的会议
         * */
        meettingEntity
                .setUrlId(pageEntity.getUrlId())
                .setUrl(pageEntity.getUrl());

        StaticLog.info("已经解析：{}  ", meettingEntity.getUrl());
        if (StringUtils.isEmpty(meettingEntity.getName())) {
            return;
        }
        meettingService.save(meettingEntity);
    }


    /*
     * 功能描述: <br>
     * 〈给定 原元素，规则返回解析之后的所有元素〉
     * @Param: [element, ruleEntity]
     * @Return: org.jsoup.select.Elements
     * @Author: miaoyi
     * @Date: 2020-04-20 14:38
     */
    @Override
    public Elements parser(Element element, SelectorTypeEnum selectorTypeEnum, String selectorName) {

        Elements elements = new Elements();
        if (SelectorTypeEnum.BY_CLASS_SELECTOR.equals(selectorTypeEnum)) {
            elements = element.getElementsByClass(selectorName);
        } else if (SelectorTypeEnum.BY_ID_SELECTOR.equals(selectorTypeEnum)) {
            Element elementById = element.getElementById(selectorName);
            elements.add(elementById);
        } else if (SelectorTypeEnum.BY_FLAG_SELECTOR.equals(selectorTypeEnum)) {
            elements = element.getElementsByTag(selectorName);
        } else if (SelectorTypeEnum.BY_ATTRIBUTE_SELECTOR.equals(selectorTypeEnum)) {
            elements = element.getElementsByAttribute(selectorName);
        } else {
            elements = element.getAllElements();
        }
        return elements;
    }

    @Override
    public String filter(Element element, FilterRuleEntity filterRuleEntity) {
        FileRuleTypeEnum fileRuleType = filterRuleEntity.getFileRuleType();

        if (element == null){
            return "";
        }

        String result = null;
        if (FileRuleTypeEnum.TEXT.equals(fileRuleType)){
            result = element.text();
        }else if (FileRuleTypeEnum.HTML.equals(fileRuleType)){
            result = element.html();
        }else if (FileRuleTypeEnum.ATTR.equals(fileRuleType)){
            result = element.attr(filterRuleEntity.getFilterKey());
        }else {
            result = element.data();       }

        String replace = result.replace(filterRuleEntity.getReplaceA(), filterRuleEntity.getFilterKey());
        String filterRules = filterRuleEntityService.filterRules(filterRuleEntity.getTableName(), replace);
        return filterRules;
    }

    @Override
    public Element parser(Element element, SelectorRuleEntity selectorRuleEntity) {
        Element result = null;
//        StaticLog.info("selectorRuleEntity：{}  ", selectorRuleEntity);

        // 解析出所有的元素
        Elements elements = parser(element, selectorRuleEntity.getSelectorTypeEnum(), selectorRuleEntity.getSelectorName());

        // 如果存在元素
        if (elements.size() > 0) {

            // 遍历每一个元素
            for (Element e : elements) {
//                StaticLog.info("Element：{}  ", e);
                // 找出所包含字段的元素
                if (-1 != selectorRuleEntity.getElementNumber() ){
                    result = elements.get(selectorRuleEntity.getElementNumber());
                    break;
                }
                if (e!= null && e.text().contains(selectorRuleEntity.getContainsStr())) {
                    result = e;
                    break;
                }
            }
        }
        return result;
    }

    @Override
    public MeettingEntity parser(PageEntity pageEntity,Element element, String type)  {
        // 通过类型查询 标签选择规则 过滤规则

        // 查询所有字段所在标签规则
        List<SelectorRuleEntity> selectorRuleEntityList = selectorRuleEntityRepository.findSelectorRuleEntitiesByType(type);

//        List<FilterRuleEntity> filterRuleEntityList = filterRuleEntityRepository.findFilterRuleEntitiesByType(type);

        MeettingEntity meettingEntity = new MeettingEntity();

        // 遍历所有规则，一条规则一个字段
        for (SelectorRuleEntity selectorRuleEntity : selectorRuleEntityList) {

            // 遍历所有字段名
            for (SelectorRuleEntity tableNameObject : selectorRuleEntityList) {
                // tableNameObject.getTableName() 字段
                if (tableNameObject.getTableName().equals(selectorRuleEntity.getTableName())){
                    // 提取字段所在的html标签
                    Element parser = parser(element, selectorRuleEntity);
                    // 查询 tableNameObject.getTableName() 字段的过滤规则
                    Optional<FilterRuleEntity> byTableName = filterRuleEntityRepository.findByTableName(tableNameObject.getTableName());
                    if (!byTableName.isPresent()){
                        return null;
                    }
                    FilterRuleEntity filterRuleEntity = byTableName.get();
                    // 过滤 html 标签 得到需要字段值
                    String filterString = filter(parser, filterRuleEntity);

                    // 优化思路  反射调用set方法
                    try {
                        Field field = meettingEntity.getClass().getDeclaredField(tableNameObject.getTableName());
                        field.setAccessible(true);
                        field.set(meettingEntity,filterString);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
//                    if (tableNameObject.getTableName().equals("scale")){
//                        StaticLog.info("scale：{}  ", meettingEntity.getScale());
//                    }
                }
            }

        }

        /*
         *
         * 保存当前解析的会议
         * */
        meettingEntity
                .setUrlId(pageEntity.getUrlId())
                .setUrl(pageEntity.getUrl());

        if (StringUtils.isEmpty(meettingEntity.getName())) {
            return null;
        }
        StaticLog.info("已经解析：{}  ", meettingEntity.getUrl());
        meettingService.save(meettingEntity);

        return meettingEntity;
    }
}

package com.example.test;


import cn.hutool.log.StaticLog;
import com.example.DemoApplication;
import com.example.module.entity.FileRuleTypeEnum;
import com.example.module.entity.FilterRuleEntity;
import com.example.module.entity.SelectorRuleEntity;
import com.example.module.entity.SelectorTypeEnum;
import com.example.service.FilterRuleEntityService;
import com.example.service.ParserService;
import com.example.service.SelectorRuleEntityService;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.beans.IntrospectionException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * @ClassName TestBean
 * @Description TODO
 * @Author miaoyi
 * @Date 2020-04-20 8:46
 * @Version 1.0
 **/

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class TestBean {

    @Autowired
    private ParserService parserService;

    @Autowired
    private SelectorRuleEntityService selectorRuleEntityService;

    @Autowired
    private FilterRuleEntityService filterRuleEntityService;

    @Test
    public void test1() throws IOException, InvocationTargetException, IntrospectionException, IllegalAccessException, NoSuchFieldException {
        Connection connect = Jsoup.connect("https://www.huodongjia.com/event-1148549877.html");
        Document document = connect.get();

        parserService.parser(null,document,"https://www.huodongjia.com/");

    }


    @Test
    public void selectorRuleEntityAndSave() throws IOException {

        Connection connect = Jsoup.connect("https://www.huodongjia.com/event-1148549877.html");
        Document document = connect.get();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ///////标签////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        SelectorRuleEntity selectorRuleEntity = new SelectorRuleEntity();
        selectorRuleEntity
                .setName("标签")
                .setContainsStr("标签")
                .setSelectorName("tags")
                .setTableName("tag")
                .setSelectorTypeEnum(SelectorTypeEnum.BY_CLASS_SELECTOR)
                .setType("https://www.huodongjia.com/");
//        ruleEntitieList.add(selectorRuleEntity);

        selectorRuleEntityService.save(selectorRuleEntity);
        Element parser = parserService.parser(document, selectorRuleEntity);


//        StaticLog.info("标签字段：{}  ", parser);

        FilterRuleEntity filterRuleEntity = new FilterRuleEntity();
        filterRuleEntity
                .setFileRuleType(FileRuleTypeEnum.TEXT)
                .setFilterKey("")
                .setName("标签")
                .setReplaceA("标签：")
                .setTableName("tag")
                .setType("https://www.huodongjia.com/")
                .setReplaceB("");
        filterRuleEntityService.save(filterRuleEntity);
        String filter = parserService.filter(parser, filterRuleEntity);
        StaticLog.info("filter 标签====：{}  ", filter);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ///////会议时间///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        SelectorRuleEntity selectorRuleEntity1 = new SelectorRuleEntity();
        selectorRuleEntity1
                .setName("会议时间")
                .setContainsStr("会议时间：")
                .setSelectorName("p")
                .setTableName("time")
                .setSelectorTypeEnum(SelectorTypeEnum.BY_FLAG_SELECTOR)
                .setType("https://www.huodongjia.com/");
        selectorRuleEntityService.save(selectorRuleEntity1);
//        ruleEntitieList.add(selectorRuleEntity);
        Element parser1 = parserService.parser(document, selectorRuleEntity1);

//        StaticLog.info("会议时间：{}  ", parser1);

        FilterRuleEntity filterRuleEntity1 = new FilterRuleEntity();
        filterRuleEntity1
                .setFileRuleType(FileRuleTypeEnum.TEXT)
                .setFilterKey("")
                .setName("会议时间")
                .setReplaceA("会议时间：")
                .setTableName("time")
                .setType("https://www.huodongjia.com/")
                .setReplaceB("");
        String filter1 = parserService.filter(parser1, filterRuleEntity1);
        filterRuleEntityService.save(filterRuleEntity1);
        StaticLog.info("filter 会议时间====：{}  ", filter1);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////会议地点/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        SelectorRuleEntity selectorRuleEntity2 = new SelectorRuleEntity();
        selectorRuleEntity2
                .setName("会议地点")
                .setContainsStr("会议地点：")
                .setSelectorName("p")
                .setTableName("location")
                .setSelectorTypeEnum(SelectorTypeEnum.BY_FLAG_SELECTOR)
                .setType("https://www.huodongjia.com/");
//        ruleEntitieList.add(selectorRuleEntity);
        Element parser2 = parserService.parser(document, selectorRuleEntity2);
        selectorRuleEntityService.save(selectorRuleEntity2);
        StaticLog.info("会议地点：{}  ", parser2);

        FilterRuleEntity filterRuleEntity2 = new FilterRuleEntity();
        filterRuleEntity2
                .setFileRuleType(FileRuleTypeEnum.TEXT)
                .setFilterKey("")
                .setName("会议地点")
                .setReplaceA("会议地点：")
                .setTableName("location")
                .setType("https://www.huodongjia.com/")
                .setReplaceB("");
        String filter2 = parserService.filter(parser2, filterRuleEntity2);
        filterRuleEntityService.save(filterRuleEntity2);
        StaticLog.info("filter 会议地点====：{}  ", filter2);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////会议规模/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        SelectorRuleEntity selectorRuleEntity3 = new SelectorRuleEntity();
        selectorRuleEntity3
                .setName("会议规模")
                .setContainsStr("会议规模：")
                .setSelectorName("p")
                .setTableName("scale")
                .setSelectorTypeEnum(SelectorTypeEnum.BY_FLAG_SELECTOR)
                .setType("https://www.huodongjia.com/");
//        ruleEntitieList.add(selectorRuleEntity);
        Element parser3 = parserService.parser(document, selectorRuleEntity3);
        selectorRuleEntityService.save(selectorRuleEntity3);
        StaticLog.info("会议地点：{}  ", parser3);

        FilterRuleEntity filterRuleEntity3 = new FilterRuleEntity();
        filterRuleEntity3
                .setFileRuleType(FileRuleTypeEnum.TEXT)
                .setFilterKey("")
                .setName("会议规模")
                .setReplaceA("会议规模：")
                .setTableName("scale")
                .setType("https://www.huodongjia.com/")
                .setReplaceB("");
        String filter3 = parserService.filter(parser3, filterRuleEntity3);
        filterRuleEntityService.save(filterRuleEntity3);
        StaticLog.info("filter 会议规模====：{}  ", filter3);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////主办单位/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        SelectorRuleEntity selectorRuleEntity4 = new SelectorRuleEntity();
        selectorRuleEntity4
                .setName("主办单位")
                .setContainsStr("主办单位：")
                .setSelectorName("p")
                .setTableName("company")
                .setSelectorTypeEnum(SelectorTypeEnum.BY_FLAG_SELECTOR)
                .setType("https://www.huodongjia.com/");
//        ruleEntitieList.add(selectorRuleEntity);
        Element parser4 = parserService.parser(document, selectorRuleEntity4);
        selectorRuleEntityService.save(selectorRuleEntity4);
        StaticLog.info("主办单位：{}  ", parser4);

        FilterRuleEntity filterRuleEntity4 = new FilterRuleEntity();
        filterRuleEntity4
                .setFileRuleType(FileRuleTypeEnum.TEXT)
                .setFilterKey("")
                .setName("主办单位")
                .setReplaceA("主办单位：")
                .setTableName("company")
                .setType("https://www.huodongjia.com/")
                .setReplaceB("");
        String filter4 = parserService.filter(parser4, filterRuleEntity4);
        filterRuleEntityService.save(filterRuleEntity4);
        StaticLog.info("filter 主办单位====：{}  ", filter4);


        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////会议主题/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        SelectorRuleEntity selectorRuleEntity5 = new SelectorRuleEntity();
        selectorRuleEntity5
                .setName("会议主题")
                .setContainsStr("")
                .setSelectorName("title")
                .setTableName("name")
                .setSelectorTypeEnum(SelectorTypeEnum.BY_FLAG_SELECTOR)
                .setType("https://www.huodongjia.com/");
//        ruleEntitieList.add(selectorRuleEntity);
        Element parser5 = parserService.parser(document, selectorRuleEntity5);
        selectorRuleEntityService.save(selectorRuleEntity5);
        StaticLog.info("会议主题：{}  ", parser5);

        FilterRuleEntity filterRuleEntity5 = new FilterRuleEntity();
        filterRuleEntity5
                .setFileRuleType(FileRuleTypeEnum.TEXT)
                .setFilterKey("")
                .setName("会议名称")
                .setTableName("name")
                .setType("https://www.huodongjia.com/")
                .setReplaceA("_门票优惠_活动家官网报名")
                .setReplaceB("");
        String filter5 = parserService.filter(parser5, filterRuleEntity5);
        filterRuleEntityService.save(filterRuleEntity5);
        StaticLog.info("filter 会议主题====：{}  ", filter5);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////会议内容/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        SelectorRuleEntity selectorRuleEntity6 = new SelectorRuleEntity();
        selectorRuleEntity6
                .setName("会议内容")
                .setContainsStr("")
                .setElementNumber(0)
                .setSelectorName("con_box")
                .setTableName("content")
                .setSelectorTypeEnum(SelectorTypeEnum.BY_CLASS_SELECTOR)
                .setType("https://www.huodongjia.com/");
//        ruleEntitieList.add(selectorRuleEntity);
        Element parser6 = parserService.parser(document, selectorRuleEntity6);
        selectorRuleEntityService.save(selectorRuleEntity6);
        StaticLog.info("会议内容：{}  ", parser6);

        FilterRuleEntity filterRuleEntity6 = new FilterRuleEntity();
        filterRuleEntity6
                .setFileRuleType(FileRuleTypeEnum.HTML)
                .setFilterKey("")
                .setName("会议内容")
                .setTableName("content")
                .setType("https://www.huodongjia.com/")
                .setReplaceB("");
        String filter6 = parserService.filter(parser6, filterRuleEntity6);
        filterRuleEntityService.save(filterRuleEntity6);
        StaticLog.info("filter 会议内容====：{}  ", filter6);



        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////会议图片/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        SelectorRuleEntity selectorRuleEntity7 = new SelectorRuleEntity();
        selectorRuleEntity7
                .setName("会议图片")
                .setContainsStr("")
                .setElementNumber(0)
                .setSelectorName("media-object")
                .setTableName("img")
                .setSelectorTypeEnum(SelectorTypeEnum.BY_CLASS_SELECTOR)
                .setType("https://www.huodongjia.com/");
//        ruleEntitieList.add(selectorRuleEntity);
        Element parser7 = parserService.parser(document, selectorRuleEntity7);
        selectorRuleEntityService.save(selectorRuleEntity7);
        StaticLog.info("会议图片：{}  ", parser7);

        FilterRuleEntity filterRuleEntity7 = new FilterRuleEntity();
        filterRuleEntity7
                .setFileRuleType(FileRuleTypeEnum.ATTR)
                .setFilterKey("src")
                .setName("会议图片")
                .setTableName("img")
                .setType("https://www.huodongjia.com/")
                .setReplaceB("");
        String filter7 = parserService.filter(parser7, filterRuleEntity7);
        filterRuleEntityService.save(filterRuleEntity7);
        StaticLog.info("filter 会议图片====：{}  ", filter7);


        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////主办方介绍/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        SelectorRuleEntity selectorRuleEntity8 = new SelectorRuleEntity();
        selectorRuleEntity8
                .setName("主办方介绍")
                .setContainsStr("")
                .setElementNumber(1)
                .setSelectorName("s_tag")
                .setTableName("introduce")
                .setSelectorTypeEnum(SelectorTypeEnum.BY_CLASS_SELECTOR)
                .setType("https://www.huodongjia.com/");
//        ruleEntitieList.add(selectorRuleEntity);
        Element parser8 = parserService.parser(document, selectorRuleEntity8);
        selectorRuleEntityService.save(selectorRuleEntity8);
        StaticLog.info("主办方介绍：{}  ", parser8);

        FilterRuleEntity filterRuleEntity8 = new FilterRuleEntity();
        filterRuleEntity8
                .setFileRuleType(FileRuleTypeEnum.HTML)
                .setFilterKey("")
                .setName("主办方介绍")
                .setTableName("introduce")
                .setType("https://www.huodongjia.com/")
                .setReplaceB("");
        String filter8 = parserService.filter(parser8, filterRuleEntity8);
        filterRuleEntityService.save(filterRuleEntity8);
        StaticLog.info("filter 主办方介绍====：{}  ", filter8);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////会议日程/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        SelectorRuleEntity selectorRuleEntity9 = new SelectorRuleEntity();
        selectorRuleEntity9
                .setName("会议日程")
                .setContainsStr("")
                .setSelectorName("meeting_2")
                .setTableName("schedule")
                .setSelectorTypeEnum(SelectorTypeEnum.BY_ID_SELECTOR)
                .setType("https://www.huodongjia.com/");
//        ruleEntitieList.add(selectorRuleEntity);
        Element parser9 = parserService.parser(document, selectorRuleEntity9);
        selectorRuleEntityService.save(selectorRuleEntity9);
        StaticLog.info("会议日程：{}  ", parser9);

        FilterRuleEntity filterRuleEntity9 = new FilterRuleEntity();
        filterRuleEntity9
                .setFileRuleType(FileRuleTypeEnum.HTML)
                .setFilterKey("")
                .setName("会议日程")
                .setTableName("schedule")
                .setType("https://www.huodongjia.com/")
                .setReplaceB("");
        String filter9 = parserService.filter(parser9, filterRuleEntity9);
        filterRuleEntityService.save(filterRuleEntity9);
        StaticLog.info("filter 会议日程====：{}  ", filter9);




        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////会议嘉宾/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        SelectorRuleEntity selectorRuleEntity10 = new SelectorRuleEntity();
        selectorRuleEntity10
                .setName("会议嘉宾")
                .setContainsStr("")
                .setSelectorName("meeting_3")
                .setTableName("guest")
                .setSelectorTypeEnum(SelectorTypeEnum.BY_ID_SELECTOR)
                .setType("https://www.huodongjia.com/");
//        ruleEntitieList.add(selectorRuleEntity);
        Element parser10 = parserService.parser(document, selectorRuleEntity10);
        selectorRuleEntityService.save(selectorRuleEntity10);
        StaticLog.info("会议嘉宾：{}  ", parser9);

        FilterRuleEntity filterRuleEntity10 = new FilterRuleEntity();
        filterRuleEntity10
                .setFileRuleType(FileRuleTypeEnum.HTML)
                .setFilterKey("")
                .setName("会议嘉宾")
                .setTableName("guest")
                .setType("https://www.huodongjia.com/")
                .setReplaceB("");
        String filter10 = parserService.filter(parser10, filterRuleEntity10);
        filterRuleEntityService.save(filterRuleEntity10);
        StaticLog.info("filter 会议嘉宾====：{}  ", filter10);



        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////参会指南/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        SelectorRuleEntity selectorRuleEntity11 = new SelectorRuleEntity();
        selectorRuleEntity11
                .setName("参会指南")
                .setContainsStr("")
                .setSelectorName("meeting_4")
                .setTableName("guide")
                .setSelectorTypeEnum(SelectorTypeEnum.BY_ID_SELECTOR)
                .setType("https://www.huodongjia.com/");
//        ruleEntitieList.add(selectorRuleEntity);
        Element parser11 = parserService.parser(document, selectorRuleEntity11);
        selectorRuleEntityService.save(selectorRuleEntity11);
        StaticLog.info("参会指南：{}  ", parser9);

        FilterRuleEntity filterRuleEntity11 = new FilterRuleEntity();
        filterRuleEntity11
                .setFileRuleType(FileRuleTypeEnum.HTML)
                .setFilterKey("")
                .setName("参会指南")
                .setTableName("guide")
                .setType("https://www.huodongjia.com/")
                .setReplaceB("");
        filterRuleEntityService.save(filterRuleEntity11);
        String filter11 = parserService.filter(parser11, filterRuleEntity11);

        StaticLog.info("filter 参会指南====：{}  ", filter11);
    }

}

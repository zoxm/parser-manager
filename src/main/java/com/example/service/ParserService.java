package com.example.service;

import com.example.module.entity.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;

/**
 * @ClassName ParserService
 * @Description TODO
 * @Author miaoyi
 * @Date 2020-03-21 12:04
 * @Version 1.0
 **/

public interface ParserService {

    void parser(PageEntity pageEntity, Document document);

    Elements parser(Element element, SelectorTypeEnum selectorTypeEnum, String selectorName);

    /*
     * 功能描述: <br>
     * 〈过滤〉
     * @Param: [element, filterRuleEntity]
     * @Return: java.lang.String
     * @Author: miaoyi
     * @Date: 2020-04-21 10:16
     */
    String filter(Element element, FilterRuleEntity filterRuleEntity);

    /*
     * 功能描述: <br>
     * 〈解析〉
     * @Param: [element, selectorRuleEntity]
     * @Return: org.jsoup.nodes.Element
     * @Author: miaoyi
     * @Date: 2020-04-21 10:16
     */
    Element parser(Element element, SelectorRuleEntity selectorRuleEntity);

    /*
     * 功能描述: <br>
     * 〈解析、过滤〉
     * @Param: [element, type]
     * @Return: com.example.module.entity.MeettingEntity
     * @Author: miaoyi
     * @Date: 2020-04-21 10:16
     */
    MeettingEntity parser(PageEntity pageEntity,Element element ,String type) throws NoSuchFieldException, IntrospectionException, InvocationTargetException, IllegalAccessException;
}

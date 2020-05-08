package com.example.processor;

import com.example.module.entity.WebSiteRuleEntity;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * @ClassName BaseProcessor
 * @Description TODO
 * @Author miaoyi
 * @Date 2020-04-27 9:25
 * @Version 1.0
 **/

public interface BaseProcessor extends PageProcessor {

    /**
     * 功能描述: <br>
     * 〈字段解析规则〉
     * @Param: [regexRuleString, containString, ]
     * @param page webmagic 下的page对象
     * @param regexRuleString webmagic 框架下的正则表达
     * @param containString 字段都包含的字符串
     * @Return: String
     * @Author: miaoyi
     * @Date: 2020-04-27 9:32
     */
    public String parser(Page page, String regexRuleString,String containString) ;
    /**
     * 功能描述: <br>
     * 〈过滤字符串〉
     * @Param: [oldString, replacedA, replaceB]
     * @param oldString 原字符串
     * @param replacedA 被替换的字符串
     * @param replaceB 替换的字符串
     * @Return: java.lang.String
     * @Author: miaoyi
     * @Date: 2020-04-27 9:38
     */
    public String replace(String oldString,String replacedA,String replaceB);
    public void run(WebSiteRuleEntity webSiteRuleEntity);

    public void process(Page page);

}

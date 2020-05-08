package com.example.processor;

import com.example.module.entity.WebSiteRuleEntity;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * @ClassName TestProcessor
 * @Description TODO
 * @Author miaoyi
 * @Date 2020-04-28 15:52
 * @Version 1.0
 **/

public interface TestProcessor extends PageProcessor {
    public void testWebSite(WebSiteRuleEntity webSiteRuleEntity) throws InterruptedException;
}

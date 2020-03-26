package com.example.service;

import com.example.module.entity.PageEntity;
import org.jsoup.nodes.Document;

/**
 * @ClassName HuodongjiaParserService
 * @Description TODO
 * @Author miaoyi
 * @Date 2020-03-21 12:04
 * @Version 1.0
 **/

public interface HuodongjiaParserService {
    void parser(PageEntity pageEntity, Document document);
}

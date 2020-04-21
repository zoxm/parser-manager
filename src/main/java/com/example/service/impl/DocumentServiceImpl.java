package com.example.service.impl;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.http.HttpUtil;
import com.example.service.DocumentService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;

/**
 * @ClassName DocumentServiceImpl
 * @Description TODO
 * @Author miaoyi
 * @Date 2020-03-18 11:08
 * @Version 1.0
 **/
@Service
public class DocumentServiceImpl implements DocumentService {
    private static final Charset CHARSET = CharsetUtil.CHARSET_GBK;
    @Override
    public Document getDocument(String url) {
        String htmlStr = HttpUtil.get(url, CHARSET);
        Document document = Jsoup.parse(htmlStr);
        return document;
    }
}

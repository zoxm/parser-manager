package com.example.service;

import org.jsoup.nodes.Document;


/**
 * @ClassName RunService
 * @Description TODO
 * @Author miaoyi
 * @Date 2020-03-18 10:51
 * @Version 1.0
 **/

public interface RunService {
    Document getDocument(String url);
}

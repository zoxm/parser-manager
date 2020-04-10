package com.example.module.entity;


import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Accessors(chain = true)
@Table(schema = "page", name = "page")
public class PageEntity extends BaseEntity implements Serializable {

/*    CREATE TABLE `page` (
            `id` int(11) NOT NULL AUTO_INCREMENT,
  `url_id` varchar(50) NOT NULL DEFAULT '0' COMMENT '关联url表的id号',
            `source_title` varchar(50) DEFAULT '0' COMMENT '期刊名',
            `article_year` varchar(50) DEFAULT '0' COMMENT '发表年',
            `article_vol` varchar(50) DEFAULT '0' COMMENT '卷',
            `article_issue` varchar(50) DEFAULT '0' COMMENT '期',
            `article_date` varchar(50) DEFAULT '0' COMMENT '发表日期',
            `article_title` varchar(50) DEFAULT '0' COMMENT '标题',
            `article_url` varchar(255) DEFAULT '0' COMMENT '原文链接',
            `local_url` varchar(255) NOT NULL DEFAULT '0' COMMENT '本地存储链接',
            `flag` int(11) NOT NULL DEFAULT '1',
            `inserttime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
            `updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `url_id` (`url_id`)
            ) ENGINE=InnoDB AUTO_INCREMENT=11255 DEFAULT CHARSET=utf8 COMMENT='下载页面源码'
    */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "url_id", columnDefinition = "varchar(50) not null default '0' COMMENT '关联url表的id号'")
    private String urlId;

    @Column(name = "url", columnDefinition = "varchar(50) not null default '0' COMMENT '会议url'")
    private String url;

    @Column(name = "source_title", columnDefinition = "varchar(50) DEFAULT '0' COMMENT '期刊名'")
    private String sourceTitle;

    @Column(name = "article_year", columnDefinition = "varchar(50) DEFAULT '0' COMMENT '发表年'")
    private String articleYear;

    @Column(name = "article_vol", columnDefinition = "varchar(50) DEFAULT '0' COMMENT '卷'")
    private String articleVol;

    @Column(name = "article_issue", columnDefinition = "varchar(50) DEFAULT '0' COMMENT '期'")
    private String articleIssue;

    @Column(name = "article_date", columnDefinition = "varchar(50) DEFAULT '0' COMMENT '发表日期'")
    private String articleDate;


    @Column(name = "article_title", columnDefinition = "varchar(50) DEFAULT '0' COMMENT '标题'")
    private String articleTitle;

    @Column(name = "article_url", columnDefinition = "varchar(255) DEFAULT '0' COMMENT '原文链接'")
    private String articleUrl;


    @Column(name = "local_url", columnDefinition = "varchar(255) NOT NULL DEFAULT '0' COMMENT '本地存储链接'")
    private String localUrl;


    @Column(name = "flag", columnDefinition = "varchar(225) not null COMMENT '是否已经解析'")
    private String  flag;
//    columnDefinition="TEXT"
    @Lob
//    @Column(name = "document", columnDefinition = "TEXT COLLATE utf8mb4_bin")
    @Column(name = "document", columnDefinition = "MEDIUMTEXT")
    private String document;



}

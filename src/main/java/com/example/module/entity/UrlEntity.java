package com.example.module.entity;


import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Accessors(chain = true)
@Table(schema = "url", name = "url")
public class UrlEntity extends BaseEntity implements Serializable {


    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "type", columnDefinition = "varchar(225) not null COMMENT 'type'")
    private String type;

    @Column(name = "vol", columnDefinition = "varchar(225) default null COMMENT 'vol'")
    private String vol;

    @Column(name = "issue", columnDefinition = "varchar(225) default null COMMENT 'issue'")
    private String issue;

    @Column(name = "title", columnDefinition = "varchar(225) not null COMMENT 'title'")
    private String title;

    @Column(name = "flag", columnDefinition = "varchar(225) not null COMMENT '是否已经下载'")
    private String flag;


    @Column(name = "url", columnDefinition = "varchar(225) not null COMMENT 'url'")
    private String url;

    @Column(name = "md5", columnDefinition = "varchar(225) not null COMMENT 'url的md5'")
    private String md5;

    @Column(name = "remark", columnDefinition = "varchar(225) default null COMMENT '是否已经下载document的标记'")
    private String remark;

}

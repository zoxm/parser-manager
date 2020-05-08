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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @Column(name = "url_id", columnDefinition = "varchar(225) not null default '0' COMMENT 'url_id'")
//    private String urlId;

    @Column(name = "url", columnDefinition = "varchar(225) not null default '0' COMMENT '会议url'")
    private String url;


    @Column(name = "md5", columnDefinition = "varchar(225) not null COMMENT 'url的md5'")
    private String  md5;
//    columnDefinition="TEXT"
    @Lob
//    @Column(name = "document", columnDefinition = "TEXT COLLATE utf8mb4_bin")
    @Column(name = "document", columnDefinition = "MEDIUMTEXT COLLATE utf8mb4_bin")
    private String document;



}

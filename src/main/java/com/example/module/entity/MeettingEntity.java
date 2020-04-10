package com.example.module.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

/**
 * @ClassName MeettingEntity
 * @Description TODO
 * @Author miaoyi
 * @Date 2020-03-21 16:53
 * @Version 1.0
 **/
@Data
@Entity
@Accessors(chain = true)
@Table(schema = "meetting", name = "meetting")
public class MeettingEntity {
//
//    会议名称
//    会议图片（需要增加）
//    会议url（需要增加）
//    会议时间
//            会议规模
//    会议地点
//            主办单位
//    会议内容（需要增加）
//    主办方介绍（需要增加）
//    会议日程（需要增加）
//    会议嘉宾（需要增加）
//    会议标签（需要增加）

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", columnDefinition = "varchar(225) not null COMMENT '会议名称'")
    private String name;

    @Column(name = "url_id", columnDefinition = "varchar(225) not null COMMENT 'page_id'")
    private String urlId;

    @Column(name = "url", columnDefinition = "varchar(225) not null COMMENT '会议url'")
    private String url;

    @Column(name = "time", columnDefinition = "varchar(225) not null COMMENT '会议时间'")
    private String time;

    @Lob
    @Column(name = "location", columnDefinition = "MEDIUMTEXT COLLATE utf8mb4_bin COMMENT '会议地点'")
    private String location;

    @Column(name = "scale", columnDefinition = "varchar(225) default null COMMENT '会议规模'")
    private String scale;

    @Column(name = "company", columnDefinition = "varchar(225) default null COMMENT '主办单位'")
    private String company;

    @Column(name = "img", columnDefinition = "varchar(225) default null COMMENT '会议图片链接'")
    private String img;

    @Lob
    @Column(name = "content", columnDefinition = "MEDIUMTEXT COLLATE utf8mb4_bin COMMENT '会议内容'")
    private String content;

    @Lob
    @Column(name = "introduce", columnDefinition = "MEDIUMTEXT COLLATE utf8mb4_bin COMMENT '会议介绍'")
    private String introduce;

    @Lob
    @Column(name = "schedule", columnDefinition = "MEDIUMTEXT COLLATE utf8mb4_bin COMMENT '会议日程'")
    private String schedule;

    @Lob
    @Column(name = "guest", columnDefinition = "MEDIUMTEXT COLLATE utf8mb4_bin COMMENT '会议嘉宾'")
    private String guest;

    @Column(name = "tag", columnDefinition = "varchar(225) default null COMMENT '会议标签'")
    private String tag;

}

package com.example.module.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @ClassName WebSiteRuleEntity
 * @Description TODO 网站的URL采集规则
 * @Author miaoyi
 * @Date 2020-04-26 16:31
 * @Version 1.0
 **/
@Data
@Entity
@Accessors(chain = true)
@Table(schema = "website_rule", name = "website_rule")
public class WebSiteRuleEntity extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "type", columnDefinition = "varchar(225) not null default '0' COMMENT '网站主页'")
    private String type;

    @Column(name = "seed", columnDefinition = "varchar(225) not null default '0' COMMENT '种子'")
    private String seed;

    @Column(name = "tip", columnDefinition = "varchar(225) default null COMMENT '任务备注'")
    private String tip;

    @Column(name = "seed_md5", columnDefinition = "varchar(225) not null default '0' COMMENT '种子的md5，可能一个网站需要多个种子,多个采集规则'")
    private String seedMd5;
    @Lob
    @Column(name = "list_xpath_rule", columnDefinition = "MEDIUMTEXT COLLATE utf8mb4_bin COMMENT '列表页xpath'")
    private String listXpathRule;
    @Lob
    @Column(name = "list_regex_rule", columnDefinition = "varchar(225) default null COMMENT '列表页regex'")
    private String listRegexRule;
    @Lob
    @Column(name = "detail_xpath_rule", columnDefinition = "MEDIUMTEXT COLLATE utf8mb4_bin COMMENT '详情页xpath'")
    private String detailXpathRule;

    @Column(name = "detail_regex_regex", columnDefinition = "varchar(225) default null COMMENT '详情页regex'")
    private String detailRegexRule;


    @Transient
    private List<FieldRuleEntity> fieldRuleEntities;

}

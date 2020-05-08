package com.example.module.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @ClassName FieldRuleEntity
 * @Description TODO 字段的采集规则
 * @Author miaoyi
 * @Date 2020-04-27 10:11
 * @Version 1.0
 **/
@Data
@Entity
@Accessors(chain = true)
@Table(schema = "filed_rule", name = "filed_rule")
public class FieldRuleEntity extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "seed_md5", columnDefinition = "varchar(225) not null default '0' COMMENT '每个种子都有一套采集规则'")
    private String seedMd5;

//    @Column(name = "filed_name_cn", columnDefinition = "varchar(225) not null default '0' COMMENT '字段中文解析'")
//    private String filedNameCN;

    @Column(name = "filed_name_en", columnDefinition = "varchar(225) not null default '0' COMMENT '字段英文名称'")
    private String filedNameEN;
    @Column(name = "xpath_rule", columnDefinition = "varchar(225) not null default '0' COMMENT 'xpath解析规则'")
    private String xpathRule;
    @Column(name = "regexRegex", columnDefinition = "varchar(225) not null default '0' COMMENT '正则解析规则'")
    private String regexRule;

}

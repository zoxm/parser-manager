package com.example.module.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @ClassName SelectorRuleEntity
 * @Description TODO
 * @Author miaoyi
 * @Date 2020-04-16 14:34
 * @Version 1.0
 **/
@Data
@Entity
@Accessors(chain = true)
@Table(schema = "filter_rule", name = "filter_rule")
public class FilterRuleEntity extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "type", columnDefinition = "varchar(225) not null COMMENT '网站类型'")
    private String type;

    @Column(name = "name", columnDefinition = "varchar(225) not null COMMENT '字段名称'")
    private String name;

    @Column(name = "table_name", columnDefinition = "varchar(225) not null COMMENT '表字段名称'")
    private String tableName;

    @Column(name = "file_rule_type", columnDefinition = "varchar(225) not null COMMENT '字段过滤类型'")
    private FileRuleTypeEnum fileRuleType;

    @Column(name = "replace_a", columnDefinition = "varchar(225) not null COMMENT '被替换字符串'")
    private String replaceA = "#";

    @Column(name = "replace_b", columnDefinition = "varchar(225) not null COMMENT '替换字符串'")
    private String replaceB = "";

    @Column(name = "filter_key", columnDefinition = "varchar(225) not null COMMENT '替换字符串'")
    private String filterKey;

}

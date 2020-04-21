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
@Table(schema = "selector_rule", name = "selector_rule")
public class SelectorRuleEntity extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "type", columnDefinition = "varchar(225) not null COMMENT '网站类型'")
    private String type;

    @Column(name = "name", columnDefinition = "varchar(225) not null COMMENT '字段名称'")
    private String name;

    @Column(name = "table_name", columnDefinition = "varchar(225) not null COMMENT '表字段名称'")
    private String tableName;

    @Column(name = "element_number", columnDefinition = "int default -1 COMMENT '元素所在序号'")
    private Integer elementNumber = -1;

    @Column(name = "selector_tame", columnDefinition = "varchar(225) default null COMMENT '选择器名称'")
    private String selectorName;

    @Column(name = "selector_type", columnDefinition = "varchar(32) not null COMMENT '选择器类型,枚举类型'")
    private SelectorTypeEnum selectorTypeEnum = SelectorTypeEnum.BY_CLASS_SELECTOR;
    /*
    * 包含字符串
    * */
    @Column(name = "containsStr", columnDefinition = "varchar(225) not null COMMENT '包含字符串'")
    private String containsStr;

}

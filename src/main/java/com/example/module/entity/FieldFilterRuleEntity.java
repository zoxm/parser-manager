package com.example.module.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @ClassName FieldFilterRuleEntity
 * @Description TODO 字段的过滤规则，由于每个字段可能需要过滤多次，所以才有单一表管理过滤规则
 * @Author miaoyi
 * @Date 2020-04-27 10:34
 * @Version 1.0
 **/
@Data
@Entity
@Accessors(chain = true)
@Table(schema = "filed_filter_rule", name = "filed_filter_rule")
public class FieldFilterRuleEntity extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "filed_id", columnDefinition = "int not null default 0 COMMENT 'filed_rule的id'")
    private Integer filedId;
    @Column(name = "replace_string", columnDefinition = "varchar(225) not null default '' COMMENT '被替换的字符串'")
    private Integer replaceString;
    @Column(name = "replacement_string", columnDefinition = "varchar(225) not null default '' COMMENT '替换的字符串'")
    private Integer replacementString;
    @Column(name = "regex_string", columnDefinition = "varchar(225) not null default '' COMMENT '正则表达'")
    private Integer regexString;
}

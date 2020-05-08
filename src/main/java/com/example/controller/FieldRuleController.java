package com.example.controller;

import cn.hutool.crypto.digest.MD5;
import com.example.module.entity.FieldRuleEntity;
import com.example.module.entity.MeettingEntity;
import com.example.service.FieldRuleService;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;

/**
 * @ClassName FiledRuleController
 * @Description TODO
 * @Author miaoyi
 * @Date 2020-04-29 9:06
 * @Version 1.0
 **/
@RestController
@CrossOrigin // 解决跨域请求
@RequestMapping("fieldrule")
public class FieldRuleController {

    @Autowired
    private FieldRuleService fieldRuleService;
    @RequestMapping("save")
    public String save(@RequestBody FieldRuleEntity fieldRuleEntity, String seed) throws IllegalAccessException {
//        meettingEntity.setSeedMd5();
//        String hex16 = MD5.create().digestHex16(seed);
//        System.out.println(hex16);
//        System.out.println(meettingEntity);
//        Class<? extends MeettingEntity> aClass = meettingEntity.getClass();
//        Field[] fields = aClass.getDeclaredFields();
//        for (Field field : fields) {
//            field.setAccessible(true);
////            FieldRuleEntity fieldRuleEntity = new FieldRuleEntity();
////            fieldRuleEntity
////                    .setFiledNameEN(field.getName())
////                    .set
//            System.out.println("name\t"+field.getName()+"\t"+"value\t"+field.get(meettingEntity));
//        }

        System.out.println(fieldRuleEntity);


//        fieldRuleService.save();
        return "ok";
    }
}

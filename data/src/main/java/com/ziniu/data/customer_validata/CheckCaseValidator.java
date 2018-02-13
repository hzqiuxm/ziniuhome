package com.ziniu.data.customer_validata;

import com.ziziu.common.constants.CaseMode;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Copyright © 2017年 ziniuxiaozhu. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2018/2/8 0008 21:21
 */

/**
 * 验证器，CheckCase泛型参数表示哪个注解，String表示被注解(验证)的字段类型,如果是注解在类上，就是类名
 */
public class CheckCaseValidator implements ConstraintValidator<CheckCase,String> {

    //验证的期望
    private CaseMode caseMode;

    @Override
    public void initialize(CheckCase constraintAnnotation) {

        this.caseMode = constraintAnnotation.value();

    }

    /**
     *
     * @param value 被验证的值
     * @param context 验证上下文
     * @return
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (value == null){
            return true;
        }

        if(caseMode == CaseMode.UPPER){
            return value.equals(value.toUpperCase());
        }else {

            return value.equals(value.toLowerCase());
        }

    }
}

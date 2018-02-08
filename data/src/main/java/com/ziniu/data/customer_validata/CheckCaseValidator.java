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
 * 验证器，CheckCase泛型参数表示哪个注解，String表示被注解的字段类型
 */
public class CheckCaseValidator implements ConstraintValidator<CheckCase,String> {

    private CaseMode caseMode;

    @Override
    public void initialize(CheckCase constraintAnnotation) {

        this.caseMode = constraintAnnotation.value();

    }

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

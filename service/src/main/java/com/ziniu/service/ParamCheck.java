package com.ziniu.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.*;


/**
 * Copyright © 2017年 ziniuxiaozhu. All rights reserved.
 *
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2018/2/8 16:24
 */

public class ParamCheck {

   private static final Logger logger = LoggerFactory.getLogger(ParamCheck.class);
   private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();


    public static <T> void validate(T t) throws Exception {

        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(t);

        if(constraintViolations.size()>0){
            List<String> messageList = new ArrayList<>();
            for (ConstraintViolation<T> constraintViolation : constraintViolations) {
                messageList.add(constraintViolation.getMessage());
            }

            throw new Exception("参数有误：" + messageList);
        }

    }
}

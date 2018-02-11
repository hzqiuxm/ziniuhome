package com.ziniu.service;


import com.ziziu.common.exception.ParamCheckException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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


    public static <T> void validate(T t) throws ParamCheckException {


        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(t);

        if(constraintViolations.size()>0){

            List<String> messageList = new ArrayList<>();
            for (ConstraintViolation<T> constraintViolation : constraintViolations) {
                messageList.add(constraintViolation.getMessage());
            }

            if(logger.isInfoEnabled()){
                messageList.forEach(System.out::println);
            }

            throw new ParamCheckException("参数有误：" + messageList.get(0));
        }

    }
}

package com.ziniu.data.customer_validata;

import com.ziziu.common.constants.CaseMode;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Copyright © 2017年 ziniuxiaozhu. All rights reserved.
 *  自定义验证：大小写的验证
 * @Author 临江仙 hzqiuxm@163.com
 * @Date 2018/2/8 0008 21:11
 */
@Target({ElementType.METHOD,ElementType.FIELD,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckCaseValidator.class)
@Documented
public @interface CheckCase {

    String message() default "输入的内容，大小写不符合";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    CaseMode value();


}

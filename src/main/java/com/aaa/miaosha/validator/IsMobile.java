package com.aaa.miaosha.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * auditor:白帅
 * Date:${Date}${Time}
 **/
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = {IsMobilevalidator.class}
)
public @interface IsMobile {

    //默认校验格式为true
    boolean required() default true;
    //校验失败显示
    String message() default "手机号码格式有误";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}

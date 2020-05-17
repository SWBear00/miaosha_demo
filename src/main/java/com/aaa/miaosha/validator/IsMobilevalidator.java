package com.aaa.miaosha.validator;


import com.aaa.miaosha.util.ValidatorUtil;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * auditor:白帅
 * Date:${Date}${Time}
 **/
public class IsMobilevalidator implements ConstraintValidator<IsMobile,String> {


    private boolean required =false;

    /**
     *
     * @param constraintAnnotation
     * 初始化方法
     */
    @Override
    public void initialize(IsMobile constraintAnnotation) {
    required=constraintAnnotation.required();
    }

    /**
     *自定义校验
     * @param s
     * @param constraintValidatorContext
     * @return
     */
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(required){
            return ValidatorUtil.isMobile(s);
        }else{
            if (StringUtils.isEmpty(s)){
                return true;
            }else{
                return ValidatorUtil.isMobile(s);
            }
        }


    }
}

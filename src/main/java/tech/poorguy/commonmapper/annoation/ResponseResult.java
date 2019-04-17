package tech.poorguy.commonmapper.annoation;

import tech.poorguy.commonmapper.result.FormatResult;
import tech.poorguy.commonmapper.result.Result;

import java.lang.annotation.*;

/**
 * @author poorguy
 * @version 0.0.1
 * @E-mail 494939649@qq.com
 * @created 2019/4/16 11:31
 */
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented//生成文档
@Inherited
public @interface ResponseResult {
    Class<? extends Result>  value() default FormatResult.class;
}


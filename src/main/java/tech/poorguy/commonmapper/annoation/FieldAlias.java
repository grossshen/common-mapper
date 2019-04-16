package tech.poorguy.commonmapper.annoation;

import java.lang.annotation.*;

/**
 * @author poorguy
 * @version 0.0.1
 * @E-mail 494939649@qq.com
 * @created 2019/4/16 15:49
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Repeatable(FieldAlias.FieldAliases.class)
public @interface FieldAlias {

    String value();

    Class<?>[] sourceClass() default { };

    /**
     * @desc 别名注解复数
     */
    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface FieldAliases {

        FieldAlias[] value();

    }
}


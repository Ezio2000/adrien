package org.adrien.sdk.file.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Xieningjun
 * @date 2023/6/13 10:43
 * @description excel注解
 */
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Excel {

    String value();

    boolean _import() default true;

    boolean export() default true;

}

package com.don.dagger2sample.retrofitsample;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * <p>
 * Description：Qualifier 注解让Dagger进行区分
 * </p>
 *
 * @author tangzhijie
 */
@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface HeaderInterceptor {

    String value() default "HeaderInterceptor";
}

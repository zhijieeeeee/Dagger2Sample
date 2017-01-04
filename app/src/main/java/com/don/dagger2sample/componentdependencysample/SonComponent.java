package com.don.dagger2sample.componentdependencysample;

import javax.inject.Named;

import dagger.Component;

/**
 * <p>
 * Description：使用方法暴露出Son,供依赖SonComponent的其他Component使用
 * </p>
 *
 * @author tangzhijie
 */
@Component(modules = SonModule.class)
public interface SonComponent {

    @Named("2")
    Son getSon2();

    @Named("1")
    Son getSon1();
}

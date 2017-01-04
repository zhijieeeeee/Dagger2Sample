package com.don.dagger2sample.componentdependencysample;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * <p>
 * Description：
 * </p>
 *
 * @author tangzhijie
 */
@Module
public class SonModule {

    @Provides
    @Named("1")
    Son provideSon1() {
        Son son = new Son();
        son.setName("亲儿子");
        return son;
    }

    @Provides
    @Named("2")
    Son provideSon2() {
        Son son = new Son();
        son.setName("私生子");
        return son;
    }
}

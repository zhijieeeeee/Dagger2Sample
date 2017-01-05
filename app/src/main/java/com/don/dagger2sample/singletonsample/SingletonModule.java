package com.don.dagger2sample.singletonsample;

import javax.inject.Singleton;

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
public class SingletonModule {

    @Provides
    @Singleton
    Test provideTest() {
        return new Test();
    }
}

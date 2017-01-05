package com.don.dagger2sample.singletonsample;

import javax.inject.Singleton;

import dagger.Component;

/**
 * <p>
 * Description：
 * </p>
 *
 * @author tangzhijie
 */
@Component(modules = SingletonModule.class)
@Singleton
public interface SingletonComponent {

    void inject(SingletonActivity singletonActivity);

    void inject(SecondActivity secondActivity);
}

package com.don.dagger2sample.retrofitsample;

import dagger.Component;

/**
 * <p>
 * Description：
 * </p>
 *
 * @author tangzhijie
 */
@Component(modules = RetrofitApiModule.class)
public interface ApiComponent {

    void inject(RetrofitSampleActivity retrofitSampleActivity);
}

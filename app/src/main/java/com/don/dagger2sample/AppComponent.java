package com.don.dagger2sample;

import com.don.dagger2sample.qualifiersample.QualifierModule;
import com.don.dagger2sample.qualifiersample.QualifierSampleActivity;
import com.don.dagger2sample.retrofitsample.RetrofitApiModule;
import com.don.dagger2sample.retrofitsample.RetrofitSampleActivity;

import dagger.Component;

/**
 * <p>
 * Description：
 * </p>
 *
 * @author tangzhijie
 */
@Component(modules = {QualifierModule.class, RetrofitApiModule.class})
public interface AppComponent {

    void inject(QualifierSampleActivity qualifierSampleActivity);

    void inject(RetrofitSampleActivity retrofitSampleActivity);
}

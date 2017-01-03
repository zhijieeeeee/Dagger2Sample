package com.don.dagger2sample.mvpsample;

import dagger.Component;

/**
 * <p>
 * Description：连接Inject和Module
 * </p>
 *
 * @author tangzhijie
 */
@Component(modules = MvpSampleModule.class)
public interface MvpSampleComponent {

    void inject(MvpSampleActivity mvpSampleActivity);
}

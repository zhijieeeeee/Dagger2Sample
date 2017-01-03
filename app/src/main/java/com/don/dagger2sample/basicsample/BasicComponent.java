package com.don.dagger2sample.basicsample;

import dagger.Component;

/**
 * <p>
 * Description：连接Inject和Module,这里没有使用Module
 * </p>
 *
 * @author tangzhijie
 */
@Component
public interface BasicComponent {
    void inject(BasicSampleActivity basicSampleActivity);
}

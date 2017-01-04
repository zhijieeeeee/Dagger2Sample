package com.don.dagger2sample.qualifiersample;

import dagger.Component;

/**
 * <p>
 * Description：
 * </p>
 *
 * @author tangzhijie
 */
@Component(modules = QualifierModule.class)
public interface QualifierComponent {

    void inject(QualifierSampleActivity qualifierSampleActivity);
}

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
public class FatherModule {

    @Provides
    Father provideFather(@Named("2") Son son) {
        Father father = new Father(son);
        return father;
    }
}

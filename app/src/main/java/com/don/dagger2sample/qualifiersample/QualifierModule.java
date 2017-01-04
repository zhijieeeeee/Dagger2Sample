package com.don.dagger2sample.qualifiersample;

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
public class QualifierModule {

    //使用Provides代替构造函数的Inject
    @Provides
    @HighLevel
    Coder provideHighLevelCoder() {
        Coder coder = new Coder();
        coder.setName("大神");
        return coder;
    }

    @Provides
    @LowLevel
    Coder provideLowLevelCoder() {
        Coder coder = new Coder();
        coder.setName("菜逼");
        return coder;
    }

}

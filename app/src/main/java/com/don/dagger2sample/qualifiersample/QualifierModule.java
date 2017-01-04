package com.don.dagger2sample.qualifiersample;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * <p>
 * Description：@Qualifier和@Named都可以用来区分依赖
 * Named 也是用@Qualifier 实现的
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

    @Provides
    @Named("初级")
    Coder provide1Coder() {
        Coder coder = new Coder();
        coder.setName("初级");
        return coder;
    }

    @Provides
    @Named("中级")
    Coder provide2Coder() {
        Coder coder = new Coder();
        coder.setName("中级");
        return coder;
    }

}

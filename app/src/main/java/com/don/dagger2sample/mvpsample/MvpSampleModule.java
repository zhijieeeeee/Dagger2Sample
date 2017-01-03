package com.don.dagger2sample.mvpsample;

import dagger.Module;
import dagger.Provides;

/**
 * <p>
 * Description：使用 @Provides 注解来标记自定义的生成函数
 * </p>
 *
 * @author tangzhijie
 */
@Module
public class MvpSampleModule {

    private final IUserLoginView view;

    public MvpSampleModule(IUserLoginView view) {
        this.view = view;
    }

    //提供public UserLoginPresenter(IUserLoginView iUserLoginView)中的IUserLoginView
    @Provides
    IUserLoginView provideIUserLoginView() {
        return view;
    }
}

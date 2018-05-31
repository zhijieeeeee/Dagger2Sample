package com.don.dagger2sample;

import android.app.Application;

import com.don.dagger2sample.singletonsample.DaggerSingletonComponent;
import com.don.dagger2sample.singletonsample.SingletonComponent;

/**
 * <p>
 * Description：创建App全局的SingletonComponent，每次注入都使用这个Component，才能保证App内全局
 * </p>
 *
 * @author tangzhijie
 */
public class MyApplication extends Application {

    public static MyApplication myApplication;

    private SingletonComponent singletonComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        myApplication=this;

        singletonComponent = DaggerSingletonComponent.create();
    }

    public SingletonComponent getSingletonComponent() {
        return singletonComponent;
    }


}

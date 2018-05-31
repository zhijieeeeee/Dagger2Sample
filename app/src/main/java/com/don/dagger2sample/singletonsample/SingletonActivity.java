package com.don.dagger2sample.singletonsample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.don.dagger2sample.MyApplication;

import javax.inject.Inject;

/**
 * <p>
 * Description：@Scope的作用只是保证依赖在@Component中是唯一的，可以理解为“局部单例”
 * Scope是需要成对存在的，
 * 在Module的Provide方法中使用了@Scope或者类上使用了@Scope
 * 那么对应的Component中也必须使用@Scope注解，
 * 当两边的@Scope名字一样时（比如同为@Singleton）,
 * 那么该Provide方法提供的依赖将会在Component中保持“局部单例”。
 * </p>
 *
 *
 * 如果依赖实例的注入来源是@Provides方法时，@Provides方法必须被@Scope注解；
 * 如果依赖实例的注入来源是@Inject注解的构造函数时，实例类必须被@Scope注解。这样@Scope注解才会有效。
 *
 *
 *
 * @author tangzhijie
 */
public class SingletonActivity extends AppCompatActivity {

    //不使用Scope,每次注入都是重新new了一个依赖
    //使用了Scope,保证依赖在@Component中是唯一的
    @Inject
    Test test;

    @Inject
    Test test1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        DaggerSingletonComponent.create().inject(this);
        MyApplication.myApplication.getSingletonComponent().inject(this);

        Log.i("MyLog", "test=" + test);
        Log.i("MyLog", "test1=" + test1);

        startActivity(new Intent(this, SecondActivity.class));
    }
}

package com.don.dagger2sample.singletonsample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.don.dagger2sample.MyApplication;

import javax.inject.Inject;

/**
 * <p>
 * Description：到了SecondActivity，
 * 因为是重新Build了一个SingletonComponent，所以Test对象的地址值也就改变了。
 * 所以@Scope的作用只是保证依赖在@Component中是唯一的
 * </p>
 *
 * @author tangzhijie
 */
public class SecondActivity extends AppCompatActivity {

    @Inject
    Test test;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        DaggerSingletonComponent.builder()
//                .singletonModule(new SingletonModule())
//                .build()
//                .inject(this);
        MyApplication.myApplication.getSingletonComponent().inject(this);

        Log.i("MyLog", "test=" + test);
    }
}

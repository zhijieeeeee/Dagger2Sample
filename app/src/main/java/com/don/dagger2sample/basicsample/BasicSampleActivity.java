package com.don.dagger2sample.basicsample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

/**
 * <p>
 * Description：Dagger2使用基础
 * </p>
 *
 * @author tangzhijie
 */
public class BasicSampleActivity extends AppCompatActivity {

    @Inject
    Student student;
    @Inject
    Teacher teacher;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Component就将@Inject注解的student与其构造函数联系了起来
        DaggerBasicComponent.builder().build().inject(this);

        student.say();
        teacher.say();
    }
}

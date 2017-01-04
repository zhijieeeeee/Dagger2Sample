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

    //使用@Inject时，不能用private修饰符修饰类的成员属性。
    //当看到某个类被@Inject标记时，就会到他的构造方法中，
    //如果这个构造方法也被@Inject标记的话，就会自动初始化这个类，从而完成依赖注入。
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

package com.don.dagger2sample.basicsample;

import android.util.Log;

import javax.inject.Inject;

/**
 * <p>
 * Description：构造函数使用Inject
 * </p>
 *
 * @author tangzhijie
 */
public class Student {

    @Inject
    public Student() {
    }

    public void say() {
        Log.i("MyLog", "我是学生張三");
    }

    public String getName() {
        return "張三";
    }
}

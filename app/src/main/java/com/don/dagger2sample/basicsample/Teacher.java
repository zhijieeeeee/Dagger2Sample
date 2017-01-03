package com.don.dagger2sample.basicsample;

import android.util.Log;

import javax.inject.Inject;

/**
 * <p>
 * Description：构造函数使用Inject
 * 如果构造函数含有参数，Dagger 会在调用构造对象的时候先去获取这些参数(不然谁来传参？)，
 * 所以你要保证它的参数也提供可被 Dagger 调用到的生成函数。
 * Student也被Inject了，所以参数是有的
 * </p>
 *
 * @author tangzhijie
 */
public class Teacher {

    Student student;

    @Inject
    public Teacher(Student student) {
        this.student = student;
    }

    public void say() {
        Log.i("MyLog", "我是老师，我的学生是" + student.getName());
    }
}

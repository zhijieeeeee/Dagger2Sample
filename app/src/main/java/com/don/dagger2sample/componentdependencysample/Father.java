package com.don.dagger2sample.componentdependencysample;

import android.util.Log;

/**
 * <p>
 * Description：
 * </p>
 *
 * @author tangzhijie
 */
public class Father {

    private Son son;

    public Father(Son son) {
        this.son = son;
    }

    public void say(){
        Log.i("MyLog", "我是父亲李，我的儿子是"+son.getName());
    }
}

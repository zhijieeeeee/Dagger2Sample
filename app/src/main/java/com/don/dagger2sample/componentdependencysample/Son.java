package com.don.dagger2sample.componentdependencysample;

import android.util.Log;

import javax.inject.Inject;

/**
 * <p>
 * Description：
 * </p>
 *
 * @author tangzhijie
 */
public class Son {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Son() {
    }

    public void say() {
        Log.i("MyLog", "我是儿子" + getName());
    }

}

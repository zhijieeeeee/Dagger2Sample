package com.don.dagger2sample.mvpsample;

import android.text.TextUtils;

import javax.inject.Inject;

/**
 * <p>
 * Description：Presenter是用作Model和View之间交互的桥梁
 * </p>
 *
 * @author tangzhijie
 */
public class UserLoginPresenter {

    private IUserLoginView iUserLoginView;

    @Inject
    public UserLoginPresenter(IUserLoginView iUserLoginView) {
        this.iUserLoginView = iUserLoginView;
    }

    public void login() {
        //这里模拟Model层的数据请求
        String username = iUserLoginView.getUsername();
        String pwd = iUserLoginView.getPwd();
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(pwd)) {
            iUserLoginView.loginResult(false);
        } else {
            iUserLoginView.loginResult(true);
        }
    }
}

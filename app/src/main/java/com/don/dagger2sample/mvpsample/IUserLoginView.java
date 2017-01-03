package com.don.dagger2sample.mvpsample;

/**
 * <p>
 * Description：
 * </p>
 *
 * @author tangzhijie
 */
public interface IUserLoginView {

    String getUsername();

    String getPwd();

    void loginResult(boolean result);
}

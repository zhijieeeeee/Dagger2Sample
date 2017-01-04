package com.don.dagger2sample.retrofitsample.retrofit;

import rx.functions.Func1;

public class HttpResultFunc<T> implements Func1<HttpResult<T>, T> {

    @Override
    public T call(HttpResult<T> httpResult) {
        if (httpResult.getErrorCode() != 0) {//请求失败
            throw new ApiException(httpResult.getReason());
        }
        return httpResult.getResult();
    }
}

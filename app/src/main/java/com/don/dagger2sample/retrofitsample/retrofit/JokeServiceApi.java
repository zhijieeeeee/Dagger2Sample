package com.don.dagger2sample.retrofitsample.retrofit;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

public interface JokeServiceApi {

    @GET(HttpConstant.HTTP_JOKE)
    Observable<HttpResult<MyJoke>> getJokeList(@QueryMap Map<String, String> param);

}

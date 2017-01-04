package com.don.dagger2sample.retrofitsample;

import com.don.dagger2sample.retrofitsample.retrofit.HttpConstant;
import com.don.dagger2sample.retrofitsample.retrofit.JokeServiceApi;

import java.io.IOException;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * <p>
 * Description：
 * </p>
 *
 * @author tangzhijie
 */
@Module
public class RetrofitApiModule {

    @Provides
    @HeaderInterceptor
    Interceptor provideHeaderInterceptor() {
        Interceptor headerInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request()
                        .newBuilder()
//                    .header("Content-Type", "application/json; charset=UTF-8")
                        .build();
                return chain.proceed(request);
            }
        };
        return headerInterceptor;
    }

    @Provides
    @LoggerInterceptor
    Interceptor provideLoggerInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

    @Provides
    OkHttpClient provideOkHttpClient(@HeaderInterceptor Interceptor headerInterceptor,
                                     @LoggerInterceptor Interceptor loggerInterceptor) {
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .retryOnConnectionFailure(false)
                .addInterceptor(loggerInterceptor)
                .addNetworkInterceptor(headerInterceptor)
//                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .build();
        return httpClient;
    }

    @Provides
    Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(HttpConstant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .callFactory(okHttpClient);
        Retrofit mRetrofit = builder.build();
        return mRetrofit;
    }

    @Provides
    JokeServiceApi provideJokeServiceApi(Retrofit retrofit) {
        return retrofit.create(JokeServiceApi.class);
    }
}

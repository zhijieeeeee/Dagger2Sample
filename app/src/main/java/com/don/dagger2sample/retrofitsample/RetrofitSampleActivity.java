package com.don.dagger2sample.retrofitsample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.don.dagger2sample.retrofitsample.retrofit.HttpResultFunc;
import com.don.dagger2sample.retrofitsample.retrofit.JokeServiceApi;
import com.don.dagger2sample.retrofitsample.retrofit.MyJoke;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * <p>
 * Description：Retrofit结合Dagger2
 * </p>
 *
 * @author tangzhijie
 */
public class RetrofitSampleActivity extends AppCompatActivity {

    @Inject
    JokeServiceApi jokeServiceApi;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerApiComponent.builder()
                .retrofitApiModule(new RetrofitApiModule())
                .build()
                .inject(this);


        Map<String, String> requestParam = new HashMap<>();
        requestParam.put("key", "c39621ea5b825547001f9858a643f182");
        requestParam.put("page", "1");
        requestParam.put("pagesize", "20");
        jokeServiceApi.getJokeList(requestParam)
                .map(new HttpResultFunc<MyJoke>())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MyJoke>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("MyLog", e.getMessage());
                    }

                    @Override
                    public void onNext(MyJoke myJoke) {
                        for (int i = 0; i < myJoke.getData().size(); i++) {
                            Log.i("MyLog", myJoke.getData().get(i).getContent());
                        }
                    }
                });
    }
}

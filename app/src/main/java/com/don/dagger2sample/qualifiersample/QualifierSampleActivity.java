package com.don.dagger2sample.qualifiersample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.don.dagger2sample.DaggerAppComponent;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * <p>
 * Description：@Qualifier注解帮助我们去为相同接口的依赖创建“tags”，也可使用@Named
 * </p>
 *
 * @author tangzhijie
 */
public class QualifierSampleActivity extends AppCompatActivity {

    @Inject
    @HighLevel
    Coder highLevelCoder;

    @Inject
    @LowLevel
    Coder lowLevelCoder;

    @Inject
    @Named("初级")
    Coder coder1;

    @Inject
    @Named("中级")
    Coder coder2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerAppComponent.builder()
                .qualifierModule(new QualifierModule())
                .build().inject(this);

        Log.i("MyLog", highLevelCoder.getName());
        Log.i("MyLog", lowLevelCoder.getName());
        Log.i("MyLog", coder1.getName());
        Log.i("MyLog", coder2.getName());
    }
}

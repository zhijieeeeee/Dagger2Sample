package com.don.dagger2sample.qualifiersample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import javax.inject.Inject;

/**
 * <p>
 * Description：@Qualifier注解帮助我们去为相同接口的依赖创建“tags”
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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerQualifierComponent.builder()
                .qualifierModule(new QualifierModule())
                .build().inject(this);

        Log.i("MyLog", highLevelCoder.getName());
        Log.i("MyLog", lowLevelCoder.getName());
    }
}

package com.don.dagger2sample.componentdependencysample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

/**
 * <p>
 * Description：
 * </p>
 *
 * @author tangzhijie
 */
public class DependencyActivity extends AppCompatActivity {

    @Inject
    Father father;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerDependencyComponent.builder()
                .fatherComponent(getFatherComponent())
                .build().inject(this);

        father.say();
    }

    private FatherComponent getFatherComponent() {
        return DaggerFatherComponent.builder().
                sonComponent(getSonComponent())
                .fatherModule(new FatherModule())
                .build();
    }

    private SonComponent getSonComponent() {
        return DaggerSonComponent.builder()
                .sonModule(new SonModule())
                .build();
    }
}

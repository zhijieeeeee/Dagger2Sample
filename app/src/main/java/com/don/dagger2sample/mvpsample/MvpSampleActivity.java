package com.don.dagger2sample.mvpsample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.don.dagger2sample.R;

import javax.inject.Inject;

/**
 * <p>
 * Description：Dagger2使用，结合mvp模式
 * </p>
 *
 * @author tangzhijie
 */
public class MvpSampleActivity extends AppCompatActivity implements IUserLoginView {

    private EditText etName;
    private EditText etPwd;
    private Button btnSure;

    @Inject
    UserLoginPresenter userLoginPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp_sample);

        etName = (EditText) findViewById(R.id.etName);
        etPwd = (EditText) findViewById(R.id.etPwd);
        btnSure = (Button) findViewById(R.id.btnSure);

        DaggerMvpSampleComponent.builder()
                .mvpSampleModule(new MvpSampleModule(this))
                .build()
                .inject(this);

        btnSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLoginPresenter.login();
            }
        });
    }


    @Override
    public String getUsername() {
        return etName.getText().toString();
    }

    @Override
    public String getPwd() {
        return etPwd.getText().toString();
    }

    @Override
    public void loginResult(boolean result) {
        if (result) {
            Toast.makeText(this, "登录成功", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "登录失败", Toast.LENGTH_LONG).show();
        }
    }
}

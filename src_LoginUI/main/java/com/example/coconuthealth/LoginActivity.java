package com.example.coconuthealth;

import android.os.Bundle;
import android.transition.Explode;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.gyf.immersionbar.ImmersionBar;


public class LoginActivity extends AppCompatActivity {
    private TextView mTvUsername;
    private EditText mEtUserName;
    private TextView mTvPassword;
    private EditText mEtPassword;
    private TextView mBtnSignUp;
    private TextView mBtnLogIn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        getWindow().setEnterTransition(new Explode());
        getWindow().setExitTransition(new Explode());

        setContentView(R.layout.activity_login);

        ImmersionBar.with(this).init();

        initView();
        initListener();
    }

    private void initListener() {
        mBtnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "注册按钮", Toast.LENGTH_SHORT).show();
            }
        });
        mBtnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "登录按钮", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 进入动画
     */
    private void setEnterAnim() {
//        overridePendingTransition(R.anim.right_top_expend_in, R.anim.activity_stay);
    }

    @Override
    public void finish() {
        super.finish();
//        overridePendingTransition(0, R.anim.right_top_pack_out);
    }

    private void initView() {
        mTvUsername = findViewById(R.id.tvUsername);
        mEtUserName = findViewById(R.id.etUserName);
        mTvPassword = findViewById(R.id.tvPassword);
        mEtPassword = findViewById(R.id.etPassword);
        mBtnSignUp = findViewById(R.id.btnSignUp);
        mBtnLogIn = findViewById(R.id.btnLogIn);
    }
}

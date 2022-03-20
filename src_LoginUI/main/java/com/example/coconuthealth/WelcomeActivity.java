package com.example.coconuthealth;

import android.app.ActivityOptions;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.transition.Explode;
import android.view.View;
import android.view.Window;
import android.widget.VideoView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.gyf.immersionbar.ImmersionBar;

public class WelcomeActivity extends AppCompatActivity {
    private ConstraintLayout mRootView;
    private VideoView mVideoView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        getWindow().setExitTransition(new Explode());

        setContentView(R.layout.activity_welcome_new);

        ImmersionBar.with(this).init();

        initView();
        initListener();
    }

    private void initListener() {
        mRootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(WelcomeActivity.this).toBundle());
                finish();
            }
        });
    }

    private void initView() {
        mRootView = findViewById(R.id.rootView);
        mVideoView = findViewById(R.id.videoView);

        String uri = ("android.resource://" + getPackageName() + "/" + R.raw.start1);
        mVideoView.setVideoURI(Uri.parse(uri));
        mVideoView.start();
    }
}

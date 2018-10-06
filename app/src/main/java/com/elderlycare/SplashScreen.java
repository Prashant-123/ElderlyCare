package com.elderlycare;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.hanks.htextview.base.AnimationListener;
import com.hanks.htextview.base.HTextView;
import com.hanks.htextview.fade.FadeTextView;

import java.util.ArrayList;
import java.util.Locale;

public class SplashScreen extends AppCompatActivity {
    private FadeTextView hTextView;
    private static int SPLASH_TIME_OUT = 500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        hTextView = findViewById(R.id.textView);
        hTextView.setAnimationListener(new SimpleAnimationListener(this));
        hTextView.animateText("Elderly Care");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreen.this, Homepage.class));
                finish();
            }
        }, SPLASH_TIME_OUT);

    }
}

    //Text Animator.
    class SimpleAnimationListener implements AnimationListener {
        private Context context;
        public SimpleAnimationListener(Context context) {
            this.context = context;
        }
        @Override
        public void onAnimationEnd(HTextView hTextView) {

        }
    }

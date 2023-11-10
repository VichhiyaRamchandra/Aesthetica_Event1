package com.example.aestheticaevent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    ImageView imageView;

    Intent intent;
    PreferenceManger preferenceManger;
    Boolean logstatus ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        imageView=findViewById(R.id.img_splash);
        preferenceManger = new PreferenceManger(SplashScreen.this);
        logstatus  = preferenceManger.getLogInSession(VariableBag.SESSION_CHECK, false);
        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setDuration(2000);
        imageView.startAnimation(fadeIn);


        Animation slideIn = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, -1.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f
        );

        slideIn.setDuration(2000);
        imageView.startAnimation(slideIn);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                if (logstatus) {
                    intent = new Intent(SplashScreen.this, LogingScreen.class);
                } else {
                    intent = new Intent(SplashScreen.this, LogingScreen.class);
                }
                startActivity(intent);
                finish();
            }
        }, 4000);

    }
}
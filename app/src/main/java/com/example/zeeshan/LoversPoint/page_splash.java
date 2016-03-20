package com.example.zeeshan.LoversPoint;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.os.Handler;

public class page_splash extends Activity{

    ImageView Iv_splash;
    int splash_timeout = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(page_splash.this, page1.class);
                startActivity(i);
            }
        },splash_timeout);
    }

}
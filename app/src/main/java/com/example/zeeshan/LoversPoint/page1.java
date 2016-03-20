package com.example.zeeshan.LoversPoint;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import android.view.View.OnClickListener;

public class page1 extends Activity{

    TextView Tv_1, Tv_2, Tv_3, Tv_4;
    Button Button_1, Button_2;
    ImageView Iv_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page1);

        Tv_1 = (TextView)findViewById(R.id.tv_1);
        Tv_1.getText();

        Tv_2 = (TextView)findViewById(R.id.tv_2);
        Tv_2.getText();

        Tv_3 = (TextView)findViewById(R.id.tv_3);
        Tv_3.getText();

        Button_1 = (Button)findViewById(R.id.button_1);
        Button_1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(page1.this, page1_signup.class);
                startActivity(i1);
            }
        });

        Iv_1 = (ImageView)findViewById(R.id.iv_1);

        Tv_4 = (TextView)findViewById(R.id.tv_4);
        Tv_4.getText();

        Button_2 = (Button)findViewById(R.id.button_2);
        Button_2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(page1.this, page1_signin.class);
                startActivity(i2);
            }
        });

    }
}
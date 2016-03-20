package com.example.zeeshan.LoversPoint;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class page1_signin extends AppCompatActivity {

    TextView Tv_1, Tv_2, Tv_3;
    EditText Et_1, Et_2;
    Button Button_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page1_signin);

        Tv_1 = (TextView)findViewById(R.id.tv_1);
        Tv_1.getText();

        Tv_2 = (TextView)findViewById(R.id.tv_2);
        Tv_2.getText();
        Et_1 = (EditText)findViewById(R.id.et_1);

        Tv_3 = (TextView)findViewById(R.id.tv_3);
        Tv_3.getText();
        Et_2 = (EditText)findViewById(R.id.et_2);

        Button_1 = (Button)findViewById(R.id.button_1);
        Button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userID = Et_1.getText().toString();
                String password = Et_2.getText().toString();

                if( userID.equals("zeeshukari@gmail.com") && password.equals("9696279127") ) {
                    Intent i = new Intent(page1_signin.this, page_hotel.class);
                    startActivity(i);
                }
                else {
                    Toast msg = Toast.makeText(page1_signin.this, "Sorry! Username-Password did not match", Toast.LENGTH_SHORT);
                    msg.show();
                }
            }
        });

    }

}
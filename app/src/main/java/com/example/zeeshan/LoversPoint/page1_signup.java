package com.example.zeeshan.LoversPoint;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zeeshan.LoversPoint.sqlite.DBHelper;

public class page1_signup extends AppCompatActivity {

    TextView Tv_1, Tv_2, Tv_3, Tv_4;
    EditText Et_1, Et_2, Et_3;
    ImageView Iv_1;
    Button Button_1;
    DBHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page1_signup);

        Tv_1 = (TextView)findViewById(R.id.tv_1);
        Tv_1.getText();
        Iv_1 = (ImageView)findViewById(R.id.iv_1);
        Iv_1.getDrawable();

        Tv_2 = (TextView)findViewById(R.id.tv_2);
        Tv_2.getText();
        Et_1 = (EditText)findViewById(R.id.et_1);

        Tv_3 = (TextView)findViewById(R.id.tv_3);
        Tv_3.getText();
        Et_2 = (EditText)findViewById(R.id.et_2);

        Tv_4 = (TextView)findViewById(R.id.tv_4);
        Tv_4.getText();
        Et_3 = (EditText)findViewById(R.id.et_3);

        mydb = new DBHelper(this);

        Button_1 = (Button)findViewById(R.id.button_1);
        Button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = Et_1.getText().toString();
                String emailID = Et_2.getText().toString();
                String password = Et_3.getText().toString();

                if( name.equals("") || emailID.equals("") || password.equals("") ) {
                    Toast msg = Toast.makeText(page1_signup.this, "Empty credentials not allowed!", Toast.LENGTH_SHORT);
                    msg.show();
                }

                if( !name.matches("^(?:\\W|\\s)*$") ) {
                    if(!emailID.equals("zeeshukari@gmail.com")) {
                        if(password.length()>=8) {

                            mydb.insertUser_Detail("Zeeshan", "zeeshukari@gmail.com", "9696279127");

                            Toast msg = Toast.makeText(page1_signup.this,"Sign Up complete", Toast.LENGTH_LONG);
                            msg.show();

                            Intent i = new Intent(page1_signup.this,page1_signin.class);
                            startActivity(i);
                        } else {
                            Toast msg3 = Toast.makeText(page1_signup.this, "Password must contain minimum 8 characters", Toast.LENGTH_SHORT);
                            msg3.show();
                        }
                    } else {
                        Toast msg2 = Toast.makeText(page1_signup.this, "Email ID is already registered", Toast.LENGTH_SHORT);
                        msg2.show();
                    }
                } else {
                    Toast msg1 = Toast.makeText(page1_signup.this, "Name cannot alphanumeric/special characters", Toast.LENGTH_SHORT);
                    msg1.show();
                }

            }
        });

    }

}
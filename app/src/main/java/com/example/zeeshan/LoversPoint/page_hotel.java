package com.example.zeeshan.LoversPoint;
import com.example.zeeshan.LoversPoint.hotel_background.city_id;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

/**
 * Created by AZforever on 10-02-2016.
 */
public class page_hotel extends AppCompatActivity{

    TextView Tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_hotel);

        String CITY = "Bangalore";

        city_id ci = new city_id();
        String city = "";
        try {
            city = ci.getCity_id(CITY);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //System.out.println(city);
        //final String MYAPPTAG= page_hotel.class.getName();
        //Log.d(MYAPPTAG, city);

        Tv1 = (TextView)findViewById(R.id.tv_1);
        //Tv1.getText();
        Tv1.setText(city);

    }

}
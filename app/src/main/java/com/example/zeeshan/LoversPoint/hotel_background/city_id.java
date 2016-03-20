package com.example.zeeshan.LoversPoint.hotel_background;

/**
 * Created by AZforever on 11-02-2016.
 */
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;

import com.example.zeeshan.LoversPoint.R;

import java.io.*;
import java.util.*;

public class city_id extends Application{

    public String getCity_id(String city) throws IOException {

        HashMap<String, String> map = new HashMap<String, String>();

        BufferedReader br = null;
        String key = "";
        String value = "";

            String sCurrentLine;

            //AssetManager am = getAssets();
            InputStream input = null;

            try {
                input = getApplicationContext().getAssets().open("city_id.txt");
                br = new BufferedReader(new InputStreamReader(input));
                while ((sCurrentLine = br.readLine()) != null) {

                    int i = 1;
                    for (String retval: sCurrentLine.split("\t", 2)){
                        if(i==1) {
                            key = retval;
                            i++;
                        }
                        else {
                            value = retval;
                            value = value.substring(0, value.length() - 3);
                        }
                    }
                    map.put(key,value);

                }
                }catch(IOException e){
                    e.printStackTrace();
                }finally {
                    try{
                        if(input != null)
                            input.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            }

        return map.get(city);

    }
}
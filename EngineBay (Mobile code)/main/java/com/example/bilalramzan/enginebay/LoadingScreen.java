package com.example.bilalramzan.enginebay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import java.lang.Thread;

/**
 * Created by Bilal Ramzan on 4/12/2017.
 */

public class LoadingScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_screen);
        Thread t=new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    sleep(3000);
                    Intent i=new Intent(getApplicationContext(),firstActivity.class);
                    startActivity(i);
                    finish();
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        };
            t.start();

    }
}

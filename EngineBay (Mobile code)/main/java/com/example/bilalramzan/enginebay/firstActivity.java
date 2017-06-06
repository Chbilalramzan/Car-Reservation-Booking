package com.example.bilalramzan.enginebay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Bilal Ramzan on 4/12/2017.
 */

public class firstActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_screen);

        Button signup=(Button)findViewById(R.id.btnSignUp);
        Button signin=(Button)findViewById(R.id.btnSingIn);

        //Signup screen
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Signup.class);
                startActivity(i);
            }

        });

        //login screen
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Login.class);
                startActivity(i);
            }
        });
    }
}

package com.example.bilalramzan.enginebay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Bilal Ramzan on 4/12/2017.
 */

public class Login extends Activity{
    EditText email,password;
    Button backlgin,login;
    TextView newAc;
    @Override
    public void onCreate( Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        email=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.pass);

        newAc=(TextView)findViewById(R.id.newAc);

        backlgin=(Button)findViewById(R.id.backlgin);
        login=(Button)findViewById(R.id.Login);

        newAc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(getApplicationContext(),Signup.class);
                startActivity(i);
            }
        });

        backlgin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Login(v);
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);

            }
        });
    }

    public void Login(View v)
    {

        String mail = email.getText().toString();
        String pass = password.getText().toString();
        String type="Login";
        URLControllor uc=new URLControllor(this);

        uc.execute(type,mail,pass);




    }

}

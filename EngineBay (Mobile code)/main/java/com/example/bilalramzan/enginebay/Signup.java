package com.example.bilalramzan.enginebay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Bilal Ramzan on 4/19/2017.
 */

public class Signup extends Activity {

    EditText username, email, password;
    Button signup, back;
    TextView newacc;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        username = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.pass);

        newacc = (TextView) findViewById(R.id.newacc);

        signup = (Button) findViewById(R.id.signup);
        back = (Button) findViewById(R.id.back);

        newacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Login.class);
                startActivity(i);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register(v);
                Intent i=new Intent(getApplicationContext(),Login.class);
                startActivity(i);

            }
        });
    }

    public void Register(View v)
    {
        String name = username.getText().toString().trim();
        String mail = email.getText().toString().trim();
        String pass = password.getText().toString().trim();
        String type="register";
        URLControllor uc=new URLControllor(this);
        uc.execute(type,name,mail,pass);


    }

}

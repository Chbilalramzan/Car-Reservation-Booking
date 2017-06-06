package com.example.bilalramzan.enginebay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Bilal Ramzan on 4/20/2017.
 */

public class CustomerDetail extends Activity {

    EditText fname,lname,pno,cnic,address,city,country,postcode;
    Button submit,backbtn;
    TextView title;
    String Title;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_detail);


        Intent i = getIntent();
        Title = i.getStringExtra("title");

        title=(TextView)findViewById(R.id.title);
        title.setText(Title);
        fname=(EditText)findViewById(R.id.fname);
        lname=(EditText)findViewById(R.id.lname);
        pno=(EditText)findViewById(R.id.pno);
        cnic=(EditText)findViewById(R.id.cnic);
        address=(EditText)findViewById(R.id.address);
        city=(EditText)findViewById(R.id.city);
        country=(EditText)findViewById(R.id.country);
        postcode=(EditText)findViewById(R.id.postcode);


        submit=(Button)findViewById(R.id.submit);
        backbtn=(Button)findViewById(R.id.backbtn);

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Customer(v);

            }
        });
    }

    public void Customer(View v)
    {

        String Fname = fname.getText().toString().trim();
        String Lname = lname.getText().toString().trim();
        String p_no = pno.getText().toString().trim();
        String CNIC = cnic.getText().toString().trim();
        String Address = address.getText().toString().trim();
        String City = city.getText().toString().trim();
        String P_code = postcode.getText().toString().trim();
        String Country = country.getText().toString().trim();


            String type = "customer_detail";
            URLControllor uc = new URLControllor(this);
            uc.execute(type, Title, Fname, Lname, p_no, CNIC, Address, City, P_code, Country);

    }
}

package com.example.bilalramzan.enginebay;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

public class Bookinginfo extends AppCompatActivity {


    private int year, month, day;
    static final int DATE_DIALOG_ID = 999;
    static final int DATE_DROP_ID = 99;

    DatePicker dpResult;
    String pick_T,pick_D,drop_T,drop_D,product,title;
    TimePicker simpleTimePicker;
    TextView date_pick,time_pick,date_drop,time_drop,car_name;
    EditText Title;
    Button next;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bookinginfo);

             Intent i = getIntent();
          product = i.getStringExtra("product");
        simpleTimePicker=(TimePicker)findViewById(R.id.simpleTimePicker); // initiate a time picker
        simpleTimePicker.setIs24HourView(false);
        car_name = (TextView) findViewById(R.id.car_name);
        car_name.setText(product);
          dpResult = (DatePicker) findViewById(R.id.dpResult);
         date_pick = (TextView) findViewById(R.id.pick_date);
            time_pick = (TextView) findViewById(R.id.pick_time);
        date_drop = (TextView) findViewById(R.id.date_drop);
        time_drop = (TextView) findViewById(R.id.time_drop);

        Title=(EditText)findViewById(R.id.Title);

        time_drop.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(Bookinginfo.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        time_drop.setText(selectedHour + ":" + selectedMinute);
                        drop_T = time_drop.getText().toString();
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
            }

        });



        time_pick.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(Bookinginfo.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        time_pick.setText(selectedHour + ":" + selectedMinute);
                        pick_T = time_pick.getText().toString();
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
            }
        });

        date_drop.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                setCurrentDateOnView();
                showDialog(DATE_DROP_ID);
            }
        });


        date_pick.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                setCurrentDateOnView();
                showDialog(DATE_DIALOG_ID);
            }
        });
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                // set date picker as current date
                return new DatePickerDialog(this, datePickerListener, year, month,day);
            case DATE_DROP_ID:
                return new DatePickerDialog(this, datedropListener, year, month,day);

        }
        return null;
    }



    @RequiresApi(api = Build.VERSION_CODES.N)
    public void setCurrentDateOnView() {

        dpResult = (DatePicker) findViewById(R.id.dpResult);

        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);

        // set current date into textview


        // set current date into datepicker
        dpResult.init(year, month, day, null);

    }



    private DatePickerDialog.OnDateSetListener datedropListener
            = new DatePickerDialog.OnDateSetListener() {

        // when dialog box is closed, below method will be called.
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {
            year = selectedYear;
            month = selectedMonth;
            day = selectedDay;

            // set selected date into textview
            date_drop.setText(new StringBuilder().append(month + 1)
                    .append("-").append(day).append("-").append(year)
                    .append(" "));

            drop_D = date_drop.getText().toString();

            // set selected date into datepicker also
            dpResult.init(year, month, day, null);

        }
    };



    private DatePickerDialog.OnDateSetListener datePickerListener
            = new DatePickerDialog.OnDateSetListener() {

        // when dialog box is closed, below method will be called.
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {
            year = selectedYear;
            month = selectedMonth;
            day = selectedDay;

            // set selected date into textview
            date_pick.setText(new StringBuilder().append(month + 1)
                    .append("-").append(day).append("-").append(year)
                    .append(" "));

            pick_D= date_pick.getText().toString();

            // set selected date into datepicker also
            dpResult.init(year, month, day, null);

            next=(Button)findViewById(R.id.next);

            next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    title=Title.getText().toString();

                    Booking(v);

                    Intent in = new Intent(v.getContext(),CustomerDetail.class);
                    in.putExtra("title",title);
                    startActivity(in);
                }
            });

        }
    };


    public void Booking(View v)
    {




        String type="booking";
        URLControllor uc=new URLControllor(this);
        uc.execute(type,pick_D,pick_T,drop_D,drop_T,product,title);


    }


}

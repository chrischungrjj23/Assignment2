package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.security.Key;
import java.util.Calendar;

public class MainActivity2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private DatePickerDialog datePickerDialog;
    private Button dateButton,save,pick;
    private Spinner sp1;
    private String date,dateDay,dateMonth;
    private TextView tvtest;
    private DatePicker datePicker;
    private EditText detail,et2;
    SharedPreferences sharedpreferences;
    public static final String MYPreference = "MYPref";
    public static final String Name = "nameKey";
    public static final String Email = "emailKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initDatePicker();
        dateButton = findViewById(R.id.datePickerButton);
        tvtest = findViewById(R.id.tvtest);
        save = findViewById(R.id.btn4);
        sp1 = findViewById(R.id.sp1);
        pick = findViewById(R.id.btn5);
        detail = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        datePicker = findViewById(R.id.DatePicker);
        dateButton.setText(getTodaysDate());
        DatePicker picker = findViewById(R.id.DatePicker);

        sharedpreferences = getSharedPreferences(MYPreference,Context.MODE_PRIVATE);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.Type, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        sp1.setAdapter(adapter);
        sp1.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,R.array.Type, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        sp1.setAdapter(adapter);
        sp1.setOnItemSelectedListener(this);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tvtest == null && sp1== null){
                    Toast.makeText(getApplicationContext(),"Please fill in the Date and Theme.",Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    Toast.makeText(getApplicationContext(), "Saved",Toast.LENGTH_SHORT).show();

                }
            }
        });

        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               datePicker.setVisibility(View.VISIBLE);
                pick.setVisibility(View.VISIBLE);



            }
        });

        pick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePicker.setVisibility(View.GONE);
                pick.setVisibility(View.GONE);
                sp1.setVisibility(View.VISIBLE);
                tvtest.setText("Selected Day: " + date);
                Toast.makeText(getApplicationContext(),date + "Selected",Toast.LENGTH_SHORT).show();
            }
        });

        int Year = picker.getYear();
        int Month =picker.getMonth()+1;
        int Day = picker.getDayOfMonth();
        picker.init(Year,Month,Day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int year, int month, int day) {
                StringBuilder builder = new StringBuilder();
                builder.append(day+"/");
                builder.append(month+1+"/");
                builder.append(year);
                date=builder.toString();
                dateDay=String.valueOf(picker.getMonth()+1);
                dateMonth=String.valueOf(picker.getDayOfMonth());
            }
        });
        tvtest.setText(date);
    }



    private String getTodaysDate()
    {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month = month + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(day, month, year);
    }

    private void initDatePicker()
    {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day)
            {
                month = month + 1;
                String date = makeDateString(day, month, year);
                dateButton.setText(date);
            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;

        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);
        //datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());

    }

    private String makeDateString(int day, int month, int year)
    {
        return getMonthFormat(month) + " " + day + " " + year;
    }

    private String getMonthFormat(int month)
    {
        if(month == 1)
            return "JAN";
        if(month == 2)
            return "FEB";
        if(month == 3)
            return "MAR";
        if(month == 4)
            return "APR";
        if(month == 5)
            return "MAY";
        if(month == 6)
            return "JUN";
        if(month == 7)
            return "JUL";
        if(month == 8)
            return "AUG";
        if(month == 9)
            return "SEP";
        if(month == 10)
            return "OCT";
        if(month == 11)
            return "NOV";
        if(month == 12)
            return "DEC";

        //default should never happen
        return "JAN";
    }

    public void openDatePicker(View view)
    {
        datePickerDialog.show();
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String choice = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(getApplicationContext(),choice,Toast.LENGTH_SHORT).show();

        if(choice == "Custom"){
            et2.setVisibility(View.VISIBLE);

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

}


package com.example.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.security.Key;

public class MainActivity2 extends AppCompatActivity {
    TextView tv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv4.findViewById(R.id.tv4);
        Bundle bundle = this.getIntent().getExtras();
        tv4.setText("Date:" + bundle.getString("Key1"));



























    }
}
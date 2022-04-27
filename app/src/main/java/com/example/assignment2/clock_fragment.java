package com.example.assignment2;

import android.os.CountDownTimer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class clock_fragment extends AppCompatActivity {
    String s1= "tomato,25,5,15;default,25,10,25";

    ArrayList<String> season;

    ListView lv1;
    Button btn_add;
    EditText PL1;
    Integer selected_pos = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clock_menu);
        lv1 = findViewById(R.id.lv1);

        s1 = s1 + ";test,20,30,40,60";

        String[] s2 =  s1.split(";");

        ArrayList<String> name = new ArrayList<>();

        for (int i=0; i<s2.length ; i++){
            String[] clockRecord = s2[i].split(",");
            name.add(clockRecord[0]);
        }



        season = new ArrayList<String>(name);

        clock_arraylist adapter=new clock_arraylist(this,season);

        lv1.setAdapter(adapter);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selected = (String) parent.getItemAtPosition(position);
                selected_pos = position;


            }
        });

        btn_add = findViewById(R.id.btn_add);
        btn_add.setText("ADD");
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



    }

}


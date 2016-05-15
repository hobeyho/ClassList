package com.nickjwpark.classlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    Button btnBack;
    TextView textViewName, textViewSchool, textViewEmail, textViewPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        textViewName = (TextView) findViewById(R.id.textViewName);
        textViewSchool = (TextView) findViewById(R.id.textViewSchool);
        textViewEmail = (TextView) findViewById(R.id.textViewEmail);
        textViewPhone = (TextView) findViewById(R.id.textViewPhone);
        btnBack = (Button) findViewById(R.id.btnBack);

        String name = "";
        String school = "";
        String email = "";
        String phone = "";

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            name = extras.getString("name");
            school = extras.getString("school");
            email = extras.getString("email");
            phone = extras.getString("phone");
        }

        textViewName.setText(name);
        textViewSchool.setText(school);
        textViewEmail.setText(email);
        textViewPhone.setText(phone);

        btnBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }
        });

    }
}

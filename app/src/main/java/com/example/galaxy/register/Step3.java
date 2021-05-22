package com.example.galaxy.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.galaxy.EntrePersonalDetailsStep2Activity;
import com.example.galaxy.R;

public class Step3 extends AppCompatActivity {

    Button regBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrepreneur_personal_details);

        regBtn = (Button) findViewById(R.id.register_btn);

        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (Step3.this, Step4.class);
                startActivity(intent);
            }
        });

    }
}
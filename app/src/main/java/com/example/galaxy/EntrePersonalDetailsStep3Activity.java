package com.example.galaxy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EntrePersonalDetailsStep3Activity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entre_personal_details_step3);

        btn = (Button) findViewById(R.id.register_btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EntrePersonalDetailsStep3Activity.this,EntreHomeActivity.class);
                startActivity(intent);
            }
        });
    }
}
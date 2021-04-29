package com.example.galaxy.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.galaxy.EntrepreneurManageOTP;
import com.example.galaxy.R;
import com.hbb20.CountryCodePicker;

public class Step1 extends AppCompatActivity {

    CountryCodePicker ccp;
    Button getOTP;
    EditText phnNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrepreneur_new_account);

        phnNumber = (EditText) findViewById(R.id.txt_phone_number);
        getOTP = (Button) findViewById(R.id.send_otp_btn);
        ccp=(CountryCodePicker)findViewById(R.id.ccp);
        ccp.registerCarrierNumberEditText(phnNumber);

        getOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(phnNumber.getText().toString().isEmpty())
                    Toast.makeText(getApplicationContext(),"Blank Field can not be processed", Toast.LENGTH_LONG).show();

                else if(phnNumber.getText().toString().length()!=11)
                    Toast.makeText(getApplicationContext(),"Invalid Phone Number",Toast.LENGTH_LONG).show();
                else {
                    Intent intent = new Intent(Step1.this, EntrepreneurManageOTP.class);
                    intent.putExtra("mobile", ccp.getFullNumberWithPlus().replace(" ", ""));
                    startActivity(intent);
                }
            }
        });
    }
}
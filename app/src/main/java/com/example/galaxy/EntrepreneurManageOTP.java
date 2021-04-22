package com.example.galaxy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class EntrepreneurManageOTP extends AppCompatActivity {

    EditText getOTP;
    Button checkOTP;
    String phonenumber;
    TextView showPhone;
    String otpid;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrepreneur_manage_o_t_p);


        phonenumber=getIntent().getStringExtra("mobile").toString();
        showPhone = (TextView) findViewById(R.id.textView2);
        getOTP = (EditText)findViewById(R.id.txt_otp);
        checkOTP = (Button)findViewById(R.id.check_otp_btn);
        mAuth = FirebaseAuth.getInstance();

        showPhone.setText("OTP has been sent to " + phonenumber);

        initiateotp();

        checkOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(getOTP.getText().toString().isEmpty())
                    Toast.makeText(getApplicationContext(),"Blank Field can not be processed", Toast.LENGTH_LONG).show();
                else if(getOTP.getText().toString().length()!=6)
                    Toast.makeText(getApplicationContext(),"Invalid OTP",Toast.LENGTH_LONG).show();
                else
                {
                    PhoneAuthCredential credential= PhoneAuthProvider.getCredential(otpid,getOTP.getText().toString());
                    signInWithPhoneAuthCredential(credential);
                }

            }
        });
    }

    private void initiateotp()
    {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phonenumber,        // Phone number to verify
                60,                 // Timeout duration
                TimeUnit.SECONDS,   // Unit of timeout
                this,               // Activity (for callback binding)
                new PhoneAuthProvider.OnVerificationStateChangedCallbacks()
                {
                    @Override
                    public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken)
                    {
                        otpid=s;
                    }

                    @Override
                    public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential)
                    {
                        signInWithPhoneAuthCredential(phoneAuthCredential);
                    }

                    @Override
                    public void onVerificationFailed(FirebaseException e) {
                        Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });        // OnVerificationStateChangedCallbacks

    }


    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {
                            startActivity(new Intent(EntrepreneurManageOTP.this,EntrepreneurHome.class));
                            finish();

                        } else {
                            Toast.makeText(getApplicationContext(),"Signing Code Error",Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

}
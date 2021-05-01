package com.example.galaxy.register;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.galaxy.R;
import com.google.android.material.tabs.TabLayout;
import com.hbb20.CountryCodePicker;

public class Step1 extends AppCompatActivity {

    CountryCodePicker ccp;
    Button getOTP;
    EditText phnNumber;

    TabLayout tabLayout;
    ViewPager2 pager2;
    FragmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrepreneur_new_account);

//        phnNumber = (EditText) findViewById(R.id.txt_phone_number);
        getOTP = (Button) findViewById(R.id.send_otp_btn);
//        ccp=(CountryCodePicker)findViewById(R.id.ccp);
//        ccp.registerCarrierNumberEditText(phnNumber);

        tabLayout = findViewById(R.id.tab_layout);
        pager2 = findViewById(R.id.view_pager2);

        FragmentManager fm = getSupportFragmentManager();
        adapter = new FragmentAdapter(fm, getLifecycle());
        pager2.setAdapter(adapter);

        tabLayout.addTab(tabLayout.newTab().setText("Phone"));
        tabLayout.addTab(tabLayout.newTab().setText("Email"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        pager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });

        getOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Step1.this, Step2.class);
                startActivity(intent);

//                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }
        });

//        getOTP.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if(phnNumber.getText().toString().isEmpty())
//                    Toast.makeText(getApplicationContext(),"Blank Field can not be processed", Toast.LENGTH_LONG).show();
//
//                else if(phnNumber.getText().toString().length()!=11)
//                    Toast.makeText(getApplicationContext(),"Invalid Phone Number",Toast.LENGTH_LONG).show();
//                else {
//                    Intent intent = new Intent(Step1.this, EntrepreneurManageOTP.class);
//                    intent.putExtra("mobile", ccp.getFullNumberWithPlus().replace(" ", ""));
//                    startActivity(intent);
//                }
//            }
//        });
    }
}
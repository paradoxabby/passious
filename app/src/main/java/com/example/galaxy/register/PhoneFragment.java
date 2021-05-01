package com.example.galaxy.register;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.galaxy.R;
import com.hbb20.CountryCodePicker;

public class PhoneFragment extends Fragment {


    CountryCodePicker ccp;
    Button getOTP;
    EditText phnNumber;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_phone, container, false);

//        phnNumber = (EditText) v.findViewById(R.id.txt_phone_number);
//        getOTP = (Button) v.findViewById(R.id.send_otp_btn);
//        ccp=(CountryCodePicker) v.findViewById(R.id.ccp);
//        ccp.registerCarrierNumberEditText(phnNumber);

//        getOTP.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if(phnNumber.getText().toString().isEmpty())
//                    Toast.makeText(getActivity(),"Blank Field can not be processed", Toast.LENGTH_LONG).show();
//
//                else if(phnNumber.getText().toString().length()!=11)
//                    Toast.makeText(getActivity(),"Invalid Phone Number",Toast.LENGTH_LONG).show();
//                else {
//                    Intent intent = new Intent(getActivity(), EntrepreneurManageOTP.class);
//                    intent.putExtra("mobile", ccp.getFullNumberWithPlus().replace(" ", ""));
//                    startActivity(intent);
//                }
//            }
//        });



    }

}
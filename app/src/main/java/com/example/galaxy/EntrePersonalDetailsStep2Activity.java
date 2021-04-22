package com.example.galaxy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class EntrePersonalDetailsStep2Activity extends AppCompatActivity {

    public void dropDownOptions(){

        arrayList_parent = new ArrayList<>();
        // arrayList_parent.add("Programmer");
        arrayList_parent.add("Developer");
        arrayList_parent.add("Marketer");
        arrayList_parent.add("Engineer");
        arrayList_parent.add("Designer");
        arrayList_parent.add("Scientist");
        arrayList_parent.add("Other");

        arrayAdapter_parent = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,arrayList_parent);
        entreParentSpinner.setAdapter(arrayAdapter_parent);


        //============ Child Spinner ==============

        arrayList_Dev = new ArrayList<>();
        arrayList_Dev.add("Web Developer");
        arrayList_Dev.add("Mobile Developer");
        arrayList_Dev.add("Software Developer");

        arrayList_Mar = new ArrayList<>();
        arrayList_Mar.add("Social Media Marketer");
        arrayList_Mar.add("Content Marketer");
        arrayList_Mar.add("Product Marketer");
        arrayList_Mar.add("Brand Marketer");

        arrayList_Eng = new ArrayList<>();
        arrayList_Eng.add("Computer Engineer");
        arrayList_Eng.add("Electrical Engineer");
        arrayList_Eng.add("Aerospace Engineer");
        arrayList_Eng.add("Chemical Engineer");
        arrayList_Eng.add("Mechanical Engineer");
        arrayList_Eng.add("Civil Engineer");

        arrayList_Des = new ArrayList<>();
        arrayList_Des.add("Graphic Designer");
        arrayList_Des.add("Animation Designer");
        arrayList_Des.add("Product Designer");
        arrayList_Des.add("Fashion Designer");
        arrayList_Des.add("UI/UX Designer");

        arrayList_Sci = new ArrayList<>();
        arrayList_Sci.add("Physicist");
        arrayList_Sci.add("Chemist");
        arrayList_Sci.add("Biologist");

        entreParentSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(position==0)
                {
                    entreChildSpinner.setVisibility(View.VISIBLE);
                    otherPassion.setVisibility(View.INVISIBLE);
                    txtView.setVisibility(View.INVISIBLE);
                    arrayAdapter_Child = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,arrayList_Dev);
                }

                if(position==1)
                {
                    entreChildSpinner.setVisibility(View.VISIBLE);
                    otherPassion.setVisibility(View.INVISIBLE);
                    txtView.setVisibility(View.INVISIBLE);
                    arrayAdapter_Child = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,arrayList_Mar);
                }

                if(position==2)
                {
                    entreChildSpinner.setVisibility(View.VISIBLE);
                    otherPassion.setVisibility(View.INVISIBLE);
                    txtView.setVisibility(View.INVISIBLE);
                    arrayAdapter_Child = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,arrayList_Eng);
                }

                if(position==3)
                {
                    entreChildSpinner.setVisibility(View.VISIBLE);
                    otherPassion.setVisibility(View.INVISIBLE);
                    txtView.setVisibility(View.INVISIBLE);
                    arrayAdapter_Child = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,arrayList_Des);
                }

                if(position==4)
                {
                    entreChildSpinner.setVisibility(View.VISIBLE);
                    otherPassion.setVisibility(View.INVISIBLE);
                    txtView.setVisibility(View.INVISIBLE);
                    arrayAdapter_Child = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,arrayList_Sci);
                }

                if(position==5)
                {
                    entreChildSpinner.setVisibility(View.GONE);
                    otherPassion.setVisibility(View.VISIBLE);
                    txtView.setVisibility(View.VISIBLE);
                }

                entreChildSpinner.setAdapter(arrayAdapter_Child);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    Spinner entreParentSpinner, entreChildSpinner;

    Button btn;

    ArrayList<String> arrayList_parent;
    ArrayAdapter<String> arrayAdapter_parent;

    EditText otherPassion;
    TextView txtView;

    ArrayList<String> arrayList_Dev, arrayList_Mar, arrayList_Eng, arrayList_Des, arrayList_Sci;
    ArrayAdapter<String> arrayAdapter_Child;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entre_personal_details_step2);

        entreParentSpinner = (Spinner) findViewById(R.id.entre_passion_parent_spinner);
        entreChildSpinner = (Spinner) findViewById(R.id.entre_passion_child_spinner);
        otherPassion = (EditText) findViewById(R.id.entre_other_passion);
        txtView = (TextView) findViewById(R.id.textView3);
        btn = (Button) findViewById(R.id.register_btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EntrePersonalDetailsStep2Activity.this,EntreHomeActivity.class);
                startActivity(intent);
            }
        });

        // method of drop down menu
        dropDownOptions();

    }
}
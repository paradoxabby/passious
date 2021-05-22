package com.example.galaxy.register;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.galaxy.R;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class Step4 extends AppCompatActivity {

        // List view
        private ListView listView;
        private EditText searchField;
        ArrayAdapter<String> adapter;
        private AlertDialog.Builder dialogBuilder;

        LinearLayout chipLayout;

        Dialog dialog;
        String tagName;

        FloatingActionButton addTag;
        Button regBtn;
        ChipGroup chipGroup;
        TextInputEditText textInputEditText;

        public void openDialog(){
            dialogBuilder = new AlertDialog.Builder(this);
            final View popUp = getLayoutInflater().inflate(R.layout.search_activity,null);
            listView = (ListView) popUp.findViewById(R.id.list_view);
            chipLayout = findViewById(R.id.chip_layout);

            String[] products = {"Designer", "Engineering", "Finance", "Operation", "Project Management",
                    "Product Management", "Sales", "Marketing", "Frontend Developer", "Backend Developer",
                    "Full-stack Developer", "IOS Developer", "Android Developer", "Data Science", "DevOps",
                    "PR & Content", "Business Intelligence", "Business Development", "Recruiting/HR", "Co-Founder", "Other"};

            adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.fields_list, products);
            listView.setAdapter(adapter);
            searchField = (EditText) popUp.findViewById(R.id.inputSearch);

            /**
             * Enabling Search Filter
             * */
            searchField.addTextChangedListener(new TextWatcher() {

                @Override
                public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                    // When user changed the Text
                    Step4.this.adapter.getFilter().filter(cs);
                }

                @Override
                public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                              int arg3) {
                    // TODO Auto-generated method stub

                }

                @Override
                public void afterTextChanged(Editable arg0) {
                    // TODO Auto-generated method stub
                }

            });

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    tagName = adapter.getItem(position);

                    chipLayout.setVisibility(View.VISIBLE);

                    LayoutInflater inflater = LayoutInflater.from(Step4.this);

                    dialog.dismiss();

                    // to add items of the list in chips
                    ArrayList<String> myList = new ArrayList<String>();

                    for (int i = 0; i < chipGroup.getChildCount(); i++) {
                        Chip chip = (Chip) chipGroup.getChildAt(i);

                        chip.toString();

                        String bla = (String) chip.getText();
                        myList.add(bla);

                    }

                    if (myList.contains(tagName)) {
                        Toast.makeText(Step4.this, "Already added", Toast.LENGTH_SHORT).show();
                    }

                    else {
                        Chip chip = (Chip) inflater.inflate(R.layout.chip_item, null, false);
                        chip.setText(tagName);
                        chip.setOnCloseIconClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                // remove tags
                                chipGroup.removeView(v);
                            }
                        });

                        chipGroup.addView(chip);
                    }
                }
            });


            dialogBuilder.setView(popUp);
            dialog = dialogBuilder.create();
            dialog.show();
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_step4);

            addTag = findViewById(R.id.btn_add_field_tag);
            regBtn = (Button) findViewById(R.id.register_btn);
            chipGroup = (ChipGroup) findViewById(R.id.chip_group);
            chipLayout = findViewById(R.id.chip_layout);

            chipLayout.setVisibility(View.INVISIBLE);


            // to add field of interest
            addTag.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    openDialog();

                }
            });


            regBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    StringBuilder tags = new StringBuilder("");
                    for(int i = 0; i < chipGroup.getChildCount(); i++)
                    {
                        Chip chip = (Chip) chipGroup.getChildAt(i);

                            if(i < chipGroup.getChildCount())
                                tags.append(chip.getText()).append(", ");

                    }

                    Toast.makeText(Step4.this,"" + tags.toString(),Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent (Step4.this, Step5.class);
                    startActivity(intent);

                }
            });


        }
    }
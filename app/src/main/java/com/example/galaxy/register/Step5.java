package com.example.galaxy.register;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.galaxy.R;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import static android.text.TextUtils.isEmpty;

public class Step5 extends AppCompatActivity {

    FloatingActionButton addTag;
    Button regBtn;
    EditText txtSkill;

    LinearLayout chipLayout;

    ChipGroup chipGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step5);

        addTag = findViewById(R.id.btn_add_skill_tag);
        regBtn = findViewById(R.id.register_btn);
        txtSkill = findViewById(R.id.txt_skills);
        chipGroup = (ChipGroup) findViewById(R.id.chip_group);
        chipLayout = findViewById(R.id.chip_layout);

        chipLayout.setVisibility(View.INVISIBLE);

        // To add skills
        addTag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String txtSkills2 = txtSkill.getText().toString().trim();
                if(isEmpty(txtSkill.getText().toString()) || txtSkills2.matches("")){
                    Toast.makeText(Step5.this,"Please enter your skill",Toast.LENGTH_SHORT).show();
                }

                else if(!isEmpty(txtSkill.getText().toString())) {

                    String tags = txtSkill.getText().toString();
                    LayoutInflater inflater = LayoutInflater.from(Step5.this);

                    ArrayList<String> myList = new ArrayList<String>();

                    for (int i = 0; i < chipGroup.getChildCount(); i++) {
                        Chip chip = (Chip) chipGroup.getChildAt(i);

                        chip.toString();

                        String bla = (String) chip.getText();
                        myList.add(bla);

                    }

                    if (myList.contains(tags.toLowerCase()) || myList.contains(tags.toUpperCase())) {
                        Toast.makeText(Step5.this, "Already added", Toast.LENGTH_SHORT).show();
                    }
                    else {

                        chipLayout.setVisibility(View.VISIBLE);
                        Chip chip = (Chip) inflater.inflate(R.layout.chip_item, null, false);
                        chip.setText(tags);
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

                txtSkill.setText(null);


            }

        });

        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringBuilder skills = new StringBuilder("");
                for(int i = 0; i < chipGroup.getChildCount(); i++)
                {
                    Chip chip = (Chip) chipGroup.getChildAt(i);

                    if(i < chipGroup.getChildCount())
                        skills.append(chip.getText()).append(", ");

                }

                Toast.makeText(Step5.this,"" + skills.toString(),Toast.LENGTH_SHORT).show();

            }
        });

    }
}
package com.example.galaxy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

public class NewStartupActivity1 extends AppCompatActivity {

    Spinner startupCategorySpinner;

    ArrayList<String> arrayList_parent;
    ArrayAdapter<String> arrayAdapter_parent;

    Button addLinksBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_startup1);

        startupCategorySpinner = (Spinner) findViewById(R.id.startup_category_parent_spinner);

        arrayList_parent = new ArrayList<>();
        // arrayList_parent.add("Programmer");
        arrayList_parent.add("Tech");
        arrayList_parent.add("Product");
        arrayList_parent.add("Medical");
        arrayList_parent.add("Designer");
        arrayList_parent.add("Scientist");
        arrayList_parent.add("Other");

        arrayAdapter_parent = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,arrayList_parent);
        startupCategorySpinner.setAdapter(arrayAdapter_parent);
    }
}
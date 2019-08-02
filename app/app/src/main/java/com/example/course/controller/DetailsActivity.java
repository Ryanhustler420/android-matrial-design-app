package com.example.course.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.example.course.R;

public class DetailsActivity extends AppCompatActivity {

    private int courseId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle bundle = getIntent().getExtras();
        courseId = bundle.getInt("course_id");
        Toast.makeText(this, "course id: " + courseId, Toast.LENGTH_LONG).show();

    }

}

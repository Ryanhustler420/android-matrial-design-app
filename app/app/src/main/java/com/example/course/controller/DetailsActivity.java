package com.example.course.controller;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.course.R;
import com.example.course.data.CourseData;
import com.example.course.model.Course;

public class DetailsActivity extends AppCompatActivity {

    private Course course;
    private ImageView courseImageView;
    private TextView courseTitle;
    private InputMethodManager inputManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setupUI();
        loadCourse();
    }

    private void loadCourse() {
        course = new CourseData().courseList().get(getIntent().getExtras().getInt("course_id"));
        courseImageView.setImageResource(course.getImageRecourseId(this));
        courseTitle.setText(course.getCourseName());
    }

    private void setupUI() {
        inputManager =  (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        courseImageView = findViewById(R.id.detailsCourseImage);
        courseTitle = findViewById(R.id.detailsCourseTitle);
    }

}

package com.example.course.controller;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.course.R;
import com.example.course.data.CourseData;
import com.example.course.model.Course;

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private Course course;
    private ImageView courseImageView;
    private TextView courseTitle;
    private InputMethodManager inputManager;
    private LinearLayout revealView;

    private boolean isEditTextVisible = false;

    private FloatingActionButton fab;

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

        revealView = findViewById(R.id.revealView);
        revealView.setVisibility(View.INVISIBLE);
        isEditTextVisible = false;

        fab = findViewById(R.id.detailsAddButton);
        fab.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.detailsAddButton:
                if(!isEditTextVisible) {
                    revealEditText(revealView);
//                    fab.setImageResource(R.drawable.ic_check);
//                    Animatable animatable = (Animatable) fab.getDrawable();
//                    animatable.start();
                }else {
                    hideEditTect(revealView);
//                    fab.setImageResource(R.drawable.ic_add);
//                    Animatable animatable = (Animatable) fab.getDrawable();
//                    animatable.start();
                }
                break;
        }
    }

    private void hideEditTect(final LinearLayout revealView) {
        int cx = revealView.getRight() - 30;
        int cy = revealView.getBottom() - 60;

        int initialRadius = revealView.getWidth();
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            final Animator anim = ViewAnimationUtils.createCircularReveal(revealView, cx, cy, initialRadius, 0f);
            anim.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    revealView.setVisibility(View.INVISIBLE);
                }
            });
            isEditTextVisible = false;
            anim.start();
        }else {
            revealView.setVisibility(View.INVISIBLE);
            isEditTextVisible = false;
        }

    }

    private void revealEditText(LinearLayout revealView) {
        int cx = revealView.getRight() - 30;
        int cy = revealView.getBottom() - 60;

        int finalRedius = Math.max(revealView.getWidth(), revealView.getHeight());
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            Animator anim = ViewAnimationUtils.createCircularReveal(revealView, cx, cy, 0f, finalRedius);
            revealView.setVisibility(View.VISIBLE);
            isEditTextVisible = true;
            anim.start();
        }else {
            revealView.setVisibility(View.VISIBLE);
            isEditTextVisible = true;
        }
    }
}

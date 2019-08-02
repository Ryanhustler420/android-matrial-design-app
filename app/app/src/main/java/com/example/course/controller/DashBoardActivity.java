package com.example.course.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.example.course.R;
import com.example.course.data.CourseListAdaptor;

public class DashBoardActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;
    private CourseListAdaptor adaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        recyclerView = findViewById(R.id.courseRecyclerView);
        adaptor = new CourseListAdaptor();

        staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);

        recyclerView.setAdapter(adaptor);

        adaptor.setOnClickListener(new CourseListAdaptor.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(DashBoardActivity.this, "Clicked: " + position, Toast.LENGTH_LONG).show();
            }
        });
    }
}

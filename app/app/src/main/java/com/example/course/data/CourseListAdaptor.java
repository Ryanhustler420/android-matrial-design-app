package com.example.course.data;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.course.R;
import com.example.course.model.Course;

import java.util.ArrayList;

public class CourseListAdaptor extends RecyclerView.Adapter<CourseListAdaptor.ViewHolder> {

    private ArrayList<Course> courseArrayList;

    @NonNull
    @Override
    public CourseListAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View courseRow = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.course_row, parent, false);
        return new ViewHolder(courseRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseListAdaptor.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return courseArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}

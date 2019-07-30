package com.example.course.data;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.course.R;
import com.example.course.model.Course;
import com.squareup.picasso.Picasso;

public class CourseListAdaptor extends RecyclerView.Adapter<CourseListAdaptor.ViewHolder> {

    //    private ArrayList<Course> courseArrayList;
    private CourseData courseData = new CourseData();

    @NonNull
    @Override
    public CourseListAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View courseRow = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.course_row, parent, false);
        return new ViewHolder(courseRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseListAdaptor.ViewHolder viewHolder, int position) {
        //  Binding Data And View
        Course course = courseData.courseList().get(position);
        viewHolder.courseTitle.setText(course.getCourseName());
        Picasso.get().load(course.getImageRecourseId(viewHolder.courseTitle.getContext()))
                .into(viewHolder.courseImageView);
        Picasso.get().load(course.getImageRecourseId(viewHolder.courseTitle.getContext()))
                .into(viewHolder.authorImageView);
    }

    // TODO: Pacaso library installation
    // https://github.com/square/picasso

    @Override
    public int getItemCount() {
        return courseData.courseList().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView courseTitle;
        public ImageView courseImageView, authorImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            courseTitle = itemView.findViewById(R.id.course_title_text);
            courseImageView = itemView.findViewById(R.id.course_image_id);
            authorImageView = itemView.findViewById(R.id.avatar_user_image);
        }
    }
}

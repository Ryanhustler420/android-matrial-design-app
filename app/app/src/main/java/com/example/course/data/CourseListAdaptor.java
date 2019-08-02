package com.example.course.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.course.R;
import com.example.course.model.Course;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class CourseListAdaptor extends RecyclerView.Adapter<CourseListAdaptor.ViewHolder>{

    //    private ArrayList<Course> courseArrayList;
    private CourseData courseData = new CourseData();
    private OnItemClickListener itemClickListener;

    @NonNull
    @Override
    public CourseListAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View courseRow = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.course_row, parent, false);
        return new ViewHolder(courseRow);
    }

    @Override
    public void onBindViewHolder(@NonNull final CourseListAdaptor.ViewHolder viewHolder, int position) {
        final Context context = viewHolder.courseTitle.getContext();

        //  Binding Data And View
        Course course = courseData.courseList().get(position);
        viewHolder.courseTitle.setText(course.getCourseName());
        Picasso.get().load(course.getImageRecourseId(context))
                .into(viewHolder.courseImageView);
        Picasso.get().load(course.getImageRecourseId(context))
                .into(viewHolder.authorImageView);

        Bitmap photo = BitmapFactory.decodeResource(context.getResources(), course.getImageRecourseId(context));
        Palette.from(photo).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(@Nullable Palette palette) {
                int BackgroundColor = palette.getMutedColor(ContextCompat.getColor(context, android.R.color.black));
                viewHolder.courseTitle.setBackgroundColor(BackgroundColor);
                viewHolder.authorImageView.setBorderColor(BackgroundColor);
            }
        });
    }

    @Override
    public int getItemCount() {
        return courseData.courseList().size();
    }

    public void setOnClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView courseTitle;
        public ImageView courseImageView;
        public CircleImageView authorImageView;

        public ViewHolder(View itemView) {
            super(itemView);

            // Very Important piece of code - register our view to receive click events;
            itemView.setOnClickListener(this);

            courseTitle = itemView.findViewById(R.id.course_title_text);
            courseImageView = itemView.findViewById(R.id.course_image_id);
            authorImageView = itemView.findViewById(R.id.avatar_user_image);
        }

        @Override
        public void onClick(View view) {
            // each card
            itemClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

}

package com.example.course.model;

import android.content.Context;

public class Course {
    private String courseName;
    private String courseImage;
    private String authorImage;

    public int getImageRecourseId(Context ctx) {
        return ctx.getResources().getIdentifier(this.courseImage, "drawable", ctx.getPackageName());
    }

    public Course(String courseName, String courseImage, String authorImage) {
        this.courseName = courseName;
        this.courseImage = courseImage;
        this.authorImage = authorImage;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseImage() {
        return courseImage;
    }

    public void setCourseImage(String courseImage) {
        this.courseImage = courseImage;
    }

    public String getAuthorImage() {
        return authorImage;
    }

    public void setAuthorImage(String authorImage) {
        this.authorImage = authorImage;
    }
}

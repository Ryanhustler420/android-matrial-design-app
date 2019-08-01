package com.example.course.data;

import com.example.course.model.Course;

import java.util.ArrayList;

public class CourseData {
    private String[] courseNames = {"AI Artificial", "Linux Course", "Advertise", "Architecture", "Bootstrap", "Css", "Hell Programming", "Java For Business", "Psycology"};

    public ArrayList<Course> courseList() {
        ArrayList<Course> list = new ArrayList<>();
        for (int i = 0; i < courseNames.length; i++) {
            Course course = new Course(courseNames[i], courseNames[i].replace(" ", "").toLowerCase(), "avatar");
            list.add(course);
        }
        return list;
    }
}

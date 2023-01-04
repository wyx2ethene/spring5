package com.wyx.bean;

import java.util.List;

public class Student {
    private List<Course> courseList;

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "courseList=" + courseList +
                '}';
    }
}

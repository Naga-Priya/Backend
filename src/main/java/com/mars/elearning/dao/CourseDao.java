package com.mars.elearning.dao;

public class CourseDao {
    String courseid;
    String coursename;
    String description;
    String instructor;
    String resources;
    float fee;

    public CourseDao() {
    }

    public CourseDao(String courseid, String coursename, String description, String instructor, String resources, float fee) {
        this.courseid = courseid;
        this.coursename = coursename;
        this.description = description;
        this.instructor = instructor;
        this.resources = resources;
        this.fee = fee;
    }

    public CourseDao(String courseid, float fee) {
        this.courseid = courseid;
        this.fee = fee;
    }

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getResources() {
        return resources;
    }

    public void setResources(String resources) {
        this.resources = resources;
    }

    public float getFee() {
        return fee;
    }

    public void setFee(float fee) {
        this.fee = fee;
    }
}

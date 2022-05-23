package com.mars.elearning.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @Column(name = "courseid")
    String courseid;
    String coursename;
    String description;
    String instructor;
    String resources;
    float fee;

    public Course() {
    }

    public Course(String courseid, String coursename, String description, String instructor, String resources, float fee) {
        this.courseid = courseid;
        this.coursename = coursename;
        this.description = description;
        this.instructor = instructor;
        this.resources = resources;
        this.fee = fee;
    }

    public String getCourseid() {
        return courseid;
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

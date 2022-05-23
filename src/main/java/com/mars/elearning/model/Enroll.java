package com.mars.elearning.model;

import javax.persistence.*;

@Entity
@Table(name="enroll")
public class Enroll {

    @Id
    @Column(name="enrollid")
    String enrollid;
    @ManyToOne(optional = false)
    @JoinColumn(name = "euser_emailid", referencedColumnName = "emailid")
    User userid;

    @ManyToOne(optional = false)
    @JoinColumn(name = "course_courseid", referencedColumnName = "courseid")
    Course courseid;

    public Enroll(String enrollid, User userid, Course courseid) {
        this.enrollid = enrollid;
        this.userid = userid;
        this.courseid = courseid;
    }

    public Enroll() {
    }

    public String getEnrollid() {
        return enrollid;
    }

    public void setEnrollid(String enrollid) {
        this.enrollid = enrollid;
    }

    public User getUserid() {
        return userid;
    }

    public void setUserid(User userid) {
        this.userid = userid;
    }

    public Course getCourseid() {
        return courseid;
    }

    public void setCourseid(Course courseid) {
        this.courseid = courseid;
    }
}

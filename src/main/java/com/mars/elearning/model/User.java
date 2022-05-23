package com.mars.elearning.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "euser")
public class User {

    String fname;
    String lname;
    java.util.Date dob;
    String role;
    @Id
    @Column(name = "emailid")
    String emailid;
    String password;
    String securityquestion;
    String securityanswer;

    public User() {
    }

    public User(String fname, String lname, Date dob, String role, String emailid, String password, String securityquestion, String securityanswer) {
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;
        this.role = role;
        this.emailid = emailid;
        this.password = password;
        this.securityquestion = securityquestion;
        this.securityanswer = securityanswer;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmailid() {
        return emailid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecurityquestion() {
        return securityquestion;
    }

    public void setSecurityquestion(String securityquestion) {
        this.securityquestion = securityquestion;
    }

    public String getSecurityanswer() {
        return securityanswer;
    }

    public void setSecurityanswer(String securityanswer) {
        this.securityanswer = securityanswer;
    }
}

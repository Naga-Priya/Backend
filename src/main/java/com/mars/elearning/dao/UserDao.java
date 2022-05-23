package com.mars.elearning.dao;

import javax.persistence.Column;
import javax.persistence.Id;

public class UserDao {
    String fname;
    String lname;
    java.util.Date dob;
    String role;
    String emailid;
    String password;
    String securityquestion;
    String securityanswer;

    public UserDao() {
    }

    public UserDao(String emailid) {
        this.emailid = emailid;
    }

    public UserDao(String emailid, String password) {
        this.emailid = emailid;
        this.password = password;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

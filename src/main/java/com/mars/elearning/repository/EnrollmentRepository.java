package com.mars.elearning.repository;

import com.mars.elearning.model.Enroll;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enroll,String> {
    public List<Enroll> findAllByUseridEmailid(String emailid);
    public List<Enroll> findAllByCourseidCourseid(String courseid);
    public Enroll findByUseridEmailidAndCourseidCourseidIgnoreCase(String emailid, String courseid);
    public boolean existsEnrollByUseridEmailidAndCourseidCourseidIgnoreCase(String emailid, String courseid);
}

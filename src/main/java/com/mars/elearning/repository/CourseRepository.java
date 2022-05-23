package com.mars.elearning.repository;

import com.mars.elearning.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {
    List<Course> findAllByCoursenameContains(String coursename);
    List<Course> findAllByInstructorContains(String instructor);
}

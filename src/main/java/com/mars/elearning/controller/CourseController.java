package com.mars.elearning.controller;

import com.mars.elearning.dao.CourseDao;
import com.mars.elearning.model.Course;
import com.mars.elearning.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
//@CrossOrigin(origins = "https://naga-priya.github.io/")
@RestController
public class CourseController {


    @Autowired
    CourseRepository courseRepo;

    //fetch courses with matching search criteria
    @GetMapping("/course")
    @ResponseBody
    public ResponseEntity<List<Course>> searchCourse(@RequestParam String key,@RequestParam String value) {
        //return "key " + key+" value "+ value;
        System.out.println(value);
        List<Course> searchResult = null;

        if(key.equals("coursename")) {
            searchResult = courseRepo.findAllByCoursenameContains(value);
        }
        else if(key.equals("instructor")) {
            searchResult = courseRepo.findAllByInstructorContains(value);
        }
        if(searchResult==null || searchResult.isEmpty()){
            return new ResponseEntity<List<Course>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Course>>(searchResult,HttpStatus.OK);


    }

    //fetch all courses
    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getCourses(){
        List<Course> courseList = courseRepo.findAll();
        return new ResponseEntity<List<Course>>(courseList, HttpStatus.OK);
    }

    //fetch a courses with given id
    @GetMapping("/courses/{courseid}")
    public ResponseEntity<Course> getCoursesById(@PathVariable("courseid") String courseid){
        Optional<Course> course = courseRepo.findById(courseid);
        if(course.isPresent()){
            return new ResponseEntity<Course>(course.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<Course>(HttpStatus.NOT_FOUND);
        }
    }

    //Add a course
    @PostMapping("/courses")
    public ResponseEntity<Course> addCourse(@RequestBody Course course){
        Optional<Course> result = courseRepo.findById(course.getCourseid());
        if(result.isPresent()){
            return new ResponseEntity<Course>(HttpStatus.FOUND);
        }
        else {
            Course newcourse = courseRepo.save(course);
            return new ResponseEntity<Course>(newcourse, HttpStatus.OK);
        }

    }

    //updata a course
    @PutMapping("/courses")
    public ResponseEntity<Course> updateCourse(@RequestBody CourseDao currentCourseDetails){
        Optional<Course> deleteCourse = courseRepo.findById(currentCourseDetails.getCourseid());
        if(deleteCourse.isPresent()){
            //can be updated
            Course _updateCourse = deleteCourse.get();
            _updateCourse.setCoursename(currentCourseDetails.getCoursename());
            _updateCourse.setDescription(currentCourseDetails.getDescription());
            _updateCourse.setInstructor(currentCourseDetails.getInstructor());
            _updateCourse.setFee(currentCourseDetails.getFee());
            _updateCourse.setResources(currentCourseDetails.getResources());
            Course savedCourse = courseRepo.save(_updateCourse);
            return new ResponseEntity<Course>(savedCourse,HttpStatus.OK);
        }
        else{
            //course not present
            return new ResponseEntity<Course>(HttpStatus.NOT_FOUND);
        }
    }

    //delete a course
    @DeleteMapping("/courses/{courseid}")
    public ResponseEntity<Course> deleteCourse(@PathVariable("courseid") String courseid){
        Optional<Course> deleteCourse = courseRepo.findById(courseid);
        if(deleteCourse.isPresent()){
            courseRepo.deleteById(courseid);
            return new ResponseEntity<Course>(deleteCourse.get(),HttpStatus.OK);
        }

        return new ResponseEntity<Course>(HttpStatus.NO_CONTENT);
    }
}

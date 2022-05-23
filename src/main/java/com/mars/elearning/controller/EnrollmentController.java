package com.mars.elearning.controller;

import com.mars.elearning.model.Enroll;
import com.mars.elearning.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
//@CrossOrigin(origins = "https://naga-priya.github.io/")
@RestController
public class EnrollmentController {

    @Autowired
    EnrollmentRepository enrollRepo;

    @GetMapping("/enrollment")
    public ResponseEntity<List<Enroll>> getAllEnrollments(){
        List<Enroll> records = enrollRepo.findAll();
        if(records.isEmpty()){
            return new ResponseEntity<List<Enroll>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Enroll>>(records,HttpStatus.OK);
    }

    @GetMapping("/enrollment/user/{emailid}")
    public ResponseEntity<List<Enroll>> getEnrollmentsByUserId(@PathVariable("emailid") String emailid){
        List<Enroll> records = enrollRepo.findAllByUseridEmailid(emailid);
        if(records.isEmpty()){
            return new ResponseEntity<List<Enroll>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Enroll>>(records,HttpStatus.OK);
    }

    @GetMapping("/enrollment/course/{courseid}")
    public ResponseEntity<List<Enroll>> getEnrollmentsByCourseId(@PathVariable("courseid") String courseid){
        List<Enroll> records = enrollRepo.findAllByCourseidCourseid(courseid);
        if(records.isEmpty()){
            return new ResponseEntity<List<Enroll>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Enroll>>(records,HttpStatus.OK);
    }

    @PostMapping("/enrollment")
    public ResponseEntity<Enroll> addEnrollment(@RequestBody Enroll enrollData){
        if(enrollRepo.findById(enrollData.getEnrollid()).isPresent()
            || enrollRepo.existsEnrollByUseridEmailidAndCourseidCourseidIgnoreCase(
                    enrollData.getUserid().getEmailid(),
                    enrollData.getCourseid().getCourseid()
        )){
            return new ResponseEntity<Enroll>(HttpStatus.FOUND);
        }
        else {
            return new ResponseEntity<Enroll>(enrollRepo.save(enrollData),HttpStatus.OK);
        }
    }
    @DeleteMapping("/enrollment/{emailid}/{courseid}")
    public ResponseEntity<Enroll> deleteEnrollment(@PathVariable("emailid") String emailid,
                                                   @PathVariable("courseid") String courseid){
        if(enrollRepo.existsEnrollByUseridEmailidAndCourseidCourseidIgnoreCase(
                emailid,courseid)){
            Enroll record = enrollRepo.findByUseridEmailidAndCourseidCourseidIgnoreCase(emailid,courseid);
            enrollRepo.delete(record);
            return new ResponseEntity<Enroll>(record,HttpStatus.OK);
        }
        return new ResponseEntity<Enroll>(HttpStatus.NO_CONTENT);
    }



}

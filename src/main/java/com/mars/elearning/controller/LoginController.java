package com.mars.elearning.controller;

import com.mars.elearning.dao.UserDao;
import com.mars.elearning.model.User;
import com.mars.elearning.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
//@CrossOrigin(origins = "https://naga-priya.github.io/")
@RestController
public class LoginController {

    @Autowired
    UserRepository userRepo;
    @RequestMapping("/")
    @ResponseBody
    public String getMessage() {
        return "Hello from Spring Boot";
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getallUsers(){
        List<User> users=userRepo.findAll();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    //search by emailid
    @GetMapping("/users/{emailid}")
    public ResponseEntity<User> getProductByManufacturer(@PathVariable("emailid") String emailid) {
        User response= userRepo.findById(emailid).get();
        return new ResponseEntity<User>(response,HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User _user = userRepo.save(user);
        return new ResponseEntity<User>(_user,HttpStatus.OK);
    }

    @PutMapping("/users")
    public ResponseEntity<User> resetPassword(@RequestBody UserDao user){
        Optional<User> _user =userRepo.findById(user.getEmailid());
        if(_user.isPresent()){
            User updatedUser = _user.get();
            updatedUser.setPassword(user.getPassword());
            User savedUser = userRepo.save(updatedUser);
            return new ResponseEntity<User>(savedUser,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<User>(HttpStatus.NOT_MODIFIED);
        }

    }
}

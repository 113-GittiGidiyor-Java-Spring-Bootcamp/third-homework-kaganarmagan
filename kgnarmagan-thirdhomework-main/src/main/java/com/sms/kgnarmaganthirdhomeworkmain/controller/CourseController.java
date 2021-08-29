package com.sms.kgnarmaganthirdhomeworkmain.controller;



import com.sms.kgnarmaganthirdhomeworkmain.entity.Course;
import com.sms.kgnarmaganthirdhomeworkmain.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;


    @GetMapping("/courses")
    public ResponseEntity<List<Course>> findCourses(@RequestParam(required = false,defaultValue = "")String name) {
        if(name.length()!=0){
            return new ResponseEntity<>(courseService.findByCourseNameContaining(name),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(courseService.findAll(), HttpStatus.OK);
        }
    }
//finds all courses
    @GetMapping("/courses/{id}")
    public ResponseEntity<Course> findCoursesById(@PathVariable int id){
        return new ResponseEntity<>(courseService.findById(id),HttpStatus.OK);
    }
//find a course with id
    @PostMapping("/courses")
    public ResponseEntity<Course> saveCourse(@RequestBody Course course){
        return new ResponseEntity<>(courseService.save(course),HttpStatus.CREATED);
    }
// save to database a new object
    @PutMapping("/courses")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course){
        return new ResponseEntity<>(courseService.update(course),HttpStatus.OK);
    }
// updates course
    @DeleteMapping("/courses/{id}")
    public ResponseEntity<String> deleteCourseById(@PathVariable int id){
        courseService.deleteById(id);
        return new ResponseEntity<>("Deleted...",HttpStatus.OK);
    }
// delete with id
    @DeleteMapping("/courses")
    public ResponseEntity<String> deleteCourse(@RequestBody Course course){
        courseService.delete(course);
        return new ResponseEntity<>("Deleted...",HttpStatus.OK);
    }
    //delete an object

    @DeleteMapping("/courses/name/{name}")
    public ResponseEntity<String> deleteCourseByName(@PathVariable String name){
        courseService.deleteByName(name);
        return new ResponseEntity<>("Deleted...",HttpStatus.OK);
    }
}

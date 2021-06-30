package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class StudentController {

    List<Student> students = new ArrayList<>();

    public StudentController() {
//        String[] interests = {"Skiing", "Holidays"};
        Student john = new Student("John", "Doe", 50, "London", "Skiing", 1);
        students.add(john);

        Student michael = new Student("Michael","Nguyen",25,"London","Java", 2);
        students.add(michael);
    }



// we have no students

     // get students
    @GetMapping("/students")
    public List<Student> getStudents() {
        return this.students;
    }
//
    @GetMapping("/student/{studentId}")
    public Student  getStudents (@PathVariable String studentId) {
        int idAsInt = Integer.parseInt(studentId);
        System.out.println(idAsInt);
        System.out.println(this.students.get(idAsInt).getFirstName());
        return  this.students.get(idAsInt);
    }


    @PostMapping("/student")
    public Student createStudent(@RequestBody Student student){
        System.out.println("The name is " + student.getFirstName());
        this.students.add(student);
        return student;
    }

//    @DeleteMapping("/student")
//    public Student deleteStudent(@RequestBody String studentId){
//        int idAsInt = Integer.parseInt(studentId);
//        System.out.println("Deleted");
//        this.students.remove(studentId);
//        return studentId;
//    }

    @DeleteMapping("/student/{studentID}")
    public Student deleteStudent(@PathVariable String studentID) {
        Student studentDeleted = students.get(Integer.parseInt(studentID));
        System.out.println(students);
        this.students.remove(Integer.parseInt(studentID));
        System.out.println(students);
        return studentDeleted;
    }
}



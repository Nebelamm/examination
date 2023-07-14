package com.neu.edu.controller;

import com.neu.edu.service.StudentService;
import com.neu.edu.utils.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StuLoginController {

    @Autowired
    StudentService studentService;

    @PostMapping("/student/login")
    public ResultModel<String> login_student(String stu_name, String password){
        System.out.println("student login");
        //System.out.println(stu_name);
        return studentService.login(stu_name,password);
    }
}

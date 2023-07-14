package com.neu.edu.controller;

import com.neu.edu.service.TeacherService;
import com.neu.edu.utils.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherLoginController {

    @Autowired
    TeacherService teacherService;

    @PostMapping ("/teacher/login")
    public ResultModel<String> login_teacher(String name, String password){
        System.out.println("teacher login");
        return teacherService.login(name,password);
    }

}

package com.neu.edu.controller;


import com.neu.edu.service.AdminService;
import com.neu.edu.service.StudentService;
import com.neu.edu.service.TeacherService;
import com.neu.edu.utils.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    AdminService adminService;
    TeacherService teacherService;
    StudentService studentService;



    @PostMapping ("/admin/login")
    public ResultModel<String> login_teacher(String name, String password){
        System.out.println("get login");
        return teacherService.login(name,password);
    }

    @PostMapping ("/admin/login")
    public ResultModel<String> login_student(String name, String password){
        System.out.println("get login");
        return studentService.login(name,password);
    }

    @PostMapping ("/admin/login")
    public ResultModel<String> login_admin(String name, String password){
        System.out.println("get login");
        return adminService.login(name,password);
    }


}

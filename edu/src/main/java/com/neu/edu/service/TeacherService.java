package com.neu.edu.service;

import com.neu.edu.utils.ResultModel;

public interface TeacherService {

    ResultModel<String> login(String name, String password);
}

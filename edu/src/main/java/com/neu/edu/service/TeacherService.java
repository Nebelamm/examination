package com.neu.edu.service;

import com.neu.edu.dto.StudentDTO;
import com.neu.edu.dto.TeacherDTO;
import com.neu.edu.utils.ResultModel;
import com.neu.edu.vo.StudentVO;
import com.neu.edu.vo.TeacherVO;

import java.util.List;

public interface TeacherService {

    ResultModel<List<TeacherVO>> findAll();
    ResultModel findById(int id);

    ResultModel add(TeacherDTO teacherDTO);
    ResultModel deleteById(int id);
    ResultModel updateById(TeacherDTO teacherDTO);

    ResultModel<String> login(String name, String password);
}

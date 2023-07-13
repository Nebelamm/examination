package com.neu.edu.mapper;

import com.neu.edu.domain.Student;
import com.neu.edu.vo.StudentVO;

import java.util.List;

public interface StudentMapper {

    List<StudentVO> findAll();
    StudentVO findById(int id);

    int add(Student student);

    int deleteById(int id);

    int updateById(Student student);


}

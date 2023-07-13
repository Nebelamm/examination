package com.neu.edu.service;

import com.neu.edu.dto.SubjectDTO;
import com.neu.edu.utils.ResultModel;
import com.neu.edu.vo.SubjectVO;

import java.util.List;

public interface SubjectService {
    ResultModel<List<SubjectVO>> findAll();

    ResultModel add(SubjectDTO subjectDTO);
    ResultModel deleteById(int id);
    ResultModel updateById(int id, String name);
}

package com.neu.edu.mapper;

import com.neu.edu.vo.SubjectVO;
import com.neu.edu.domain.Subject;
import java.util.List;

public interface SubjectMapper {
    List<SubjectVO> findAll();

    int add(Subject subject);

    int deleteById(int id);

    int updateById(Subject subject);
}

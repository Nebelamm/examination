package com.neu.edu.mapper;

import com.neu.edu.vo.TeacherVO;

import java.util.Map;

public interface TeacherMapper {

    TeacherVO login(Map<String  ,String> map);
}

package com.neu.edu.mapper;


import com.neu.edu.domain.Exampaper;
import com.neu.edu.domain.Score;
import com.neu.edu.domain.Student;
import com.neu.edu.utils.ResultModel;
import com.neu.edu.vo.ExampaperVO;
import com.neu.edu.vo.ScoreVO;
import com.neu.edu.vo.StudentVO;

import java.util.List;

public interface ExampaperMapper {
    List<ExampaperVO> findById(int id);

    int add(Exampaper exampaper);

}

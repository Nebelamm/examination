package com.neu.edu.service;

import com.neu.edu.dto.ExampaperDTO;
import com.neu.edu.dto.ScoreDTO;
import com.neu.edu.dto.StudentDTO;
import com.neu.edu.utils.ResultModel;
import com.neu.edu.vo.ExampaperVO;
import com.neu.edu.vo.ScoreVO;

import java.util.List;

public interface ExampaperService {

    ResultModel<List<ExampaperVO>> findById(int id);
    ResultModel add(ExampaperDTO exampaperDTO);
}

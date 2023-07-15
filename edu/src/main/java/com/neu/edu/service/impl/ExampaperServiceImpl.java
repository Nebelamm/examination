package com.neu.edu.service.impl;


import com.neu.edu.domain.Score;
import com.neu.edu.domain.Exampaper;
import com.neu.edu.dto.ExampaperDTO;
import com.neu.edu.dto.ScoreDTO;
import com.neu.edu.mapper.ExampaperMapper;
import com.neu.edu.mapper.ScoreMapper;
import com.neu.edu.service.ExampaperService;
import com.neu.edu.service.ScoreService;
import com.neu.edu.utils.ResultModel;
import com.neu.edu.vo.ExampaperVO;
import com.neu.edu.vo.ScoreVO;
import com.neu.edu.vo.ExampaperVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExampaperServiceImpl implements ExampaperService {

    @Autowired
    ExampaperMapper exampaperMapper;


    @Override
    public ResultModel findById(int id) {
        ResultModel<List<ExampaperVO>> resultModel = new ResultModel();
        List<ExampaperVO> exampaperVOList = exampaperMapper.findById(id);

        if(exampaperVOList==null){
            resultModel.setCode(401);
            resultModel.setMsg("该学科暂无题目");
        }else {
            resultModel.setCode(200);
            resultModel.setMsg("查询学科题目成功");
            resultModel.setData(exampaperVOList);
        }
        return resultModel;
    }

    @Override
    public ResultModel add(ExampaperDTO exampaperDTO) {

        ResultModel resultModel = new ResultModel();

        //DTO--domain
        Exampaper exampaper = new Exampaper();
        exampaper.setCourse_id(exampaperDTO.getCourse_id());
        exampaper.setTitle_id(exampaperDTO.getTitle_id());

        System.out.println(exampaper.getCourse_id());
        System.out.println(exampaper.getTitle_id());

        if(exampaperMapper.add(exampaper)==0){
            resultModel.setCode(401);
            resultModel.setMsg("试卷添加题目失败,该题目已存在");

        }else {
            resultModel.setCode(200);
            resultModel.setMsg("试卷添加题目成功");
            resultModel.setData(exampaper.getTitle_id());
        }
        return resultModel;
    }
}

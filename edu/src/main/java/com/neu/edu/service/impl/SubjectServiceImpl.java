package com.neu.edu.service.impl;

import com.neu.edu.dto.SubjectDTO;
import com.neu.edu.mapper.SubjectMapper;
import com.neu.edu.service.SubjectService;
import com.neu.edu.utils.ResultModel;
import com.neu.edu.vo.SubjectVO;
import com.neu.edu.domain.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    SubjectMapper subjectMapper;

    @Override
    public ResultModel<List<SubjectVO>> findAll(){
        ResultModel<List<SubjectVO>> resultModel = new ResultModel<List<SubjectVO>>();
        List<SubjectVO> subjectVOList = subjectMapper.findAll();
        resultModel.setCode(200);
        resultModel.setMsg("查询学科成功");
        resultModel.setData(subjectVOList);
        return resultModel;
    }

    @Override
    public ResultModel add(SubjectDTO subjectDTO) {
        ResultModel resultModel = new ResultModel();
        //DTO--domain
        Subject subject = new Subject();
        subject.setName(subjectDTO.getName());
        subjectMapper.add(subject);

        resultModel.setCode(200);
        resultModel.setMsg("添加学科成功");
        return resultModel;
    }

    @Override
    public ResultModel deleteById(int id) {
        System.out.println(id);
        ResultModel resultModel = new ResultModel();

        subjectMapper.deleteById(id);

        resultModel.setCode(200);
        resultModel.setMsg("删除学科成功");
        return resultModel;
    }

    @Override
    public ResultModel updateById(int id, String name) {
        ResultModel resultModel = new ResultModel();
        //DTO--domain
        Subject subject = new Subject();
        subject.setName(name);
        subject.setId(id);
        subjectMapper.updateById(subject);

        resultModel.setCode(200);
        resultModel.setMsg("更新学科成功");
        return resultModel;
    }

}

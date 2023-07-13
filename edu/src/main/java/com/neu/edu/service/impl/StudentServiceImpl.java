package com.neu.edu.service.impl;

import com.neu.edu.domain.Student;
import com.neu.edu.dto.StudentDTO;
import com.neu.edu.mapper.StudentMapper;
import com.neu.edu.service.StudentService;
import com.neu.edu.utils.ResultModel;
import com.neu.edu.vo.StudentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentMapper studentMapper;

    @Override
    public ResultModel<List<StudentVO>> findAll(){
        ResultModel<List<StudentVO>> resultModel = new ResultModel<List<StudentVO>>();
        List<StudentVO> studentVOList = studentMapper.findAll();
        resultModel.setCode(200);
        resultModel.setMsg("查询学生成功");
        resultModel.setData(studentVOList);
        return resultModel;
    }

    @Override
    public ResultModel findById(int id){
        ResultModel resultModel = new ResultModel();
        StudentVO studentVO = studentMapper.findById(id);

        resultModel.setCode(200);
        resultModel.setMsg("查询学生成功");
        resultModel.setData(studentVO);
        return resultModel;
    }


    @Override
    public ResultModel add(StudentDTO studentDTO) {
        ResultModel resultModel = new ResultModel();
        //DTO--domain
        Student student = new Student();
        student.setStudent_id(studentDTO.getStudent_id());
        student.setStu_name(studentDTO.getStu_name());
        student.setPassword(studentDTO.getPassword());
        student.setPhone(studentDTO.getPhone());
        student.setMail(studentDTO.getMail());
        studentMapper.add(student);

        resultModel.setCode(200);
        resultModel.setMsg("添加学生成功");
        return resultModel;
    }

    @Override
    public ResultModel deleteById(int id) {
        ResultModel resultModel = new ResultModel();

        studentMapper.deleteById(id);
        resultModel.setCode(200);
        resultModel.setMsg("删除学生成功");
        return resultModel;
    }

    @Override
    public ResultModel updateById(StudentDTO studentDTO) {
        ResultModel resultModel = new ResultModel();
        //DTO--domain
        Student student = new Student();
        student.setStudent_id(studentDTO.getStudent_id());
        student.setStu_name(studentDTO.getStu_name());
        student.setPassword(studentDTO.getPassword());
        student.setPhone(studentDTO.getPhone());
        student.setMail(studentDTO.getMail());

        studentMapper.updateById(student);
        System.out.println(student.getStu_name());

        resultModel.setCode(200);
        resultModel.setMsg("更新学生成功");
        return resultModel;
    }

}

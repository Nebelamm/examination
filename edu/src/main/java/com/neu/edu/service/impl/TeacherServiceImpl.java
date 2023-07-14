package com.neu.edu.service.impl;

import com.neu.edu.mapper.TeacherMapper;
import com.neu.edu.service.TeacherService;
import com.neu.edu.utils.ResultModel;
import com.neu.edu.vo.TeacherVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public ResultModel login(String name, String password){
        ResultModel resultModel = new ResultModel();

        Map<String, String> map = new HashMap<String,String>();
        map.put("name", name);
        map.put("password", password);

        TeacherVO teacherVO = teacherMapper.login(map);

        if(teacherVO==null){
            resultModel.setCode(401);
            resultModel.setMsg("账号或密码错误");
        }else {
            resultModel.setCode(200);
            resultModel.setMsg("登录成功");
        }
        //resultModel.setData();
        return resultModel;
    }
}

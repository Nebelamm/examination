package com.neu.edu.controller;

import com.neu.edu.dto.SubjectDTO;
import com.neu.edu.service.SubjectService;
import com.neu.edu.utils.ResultModel;
import com.neu.edu.vo.SubjectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @GetMapping("")
    public ResultModel<List<SubjectVO>> findAll(){
        return subjectService.findAll();
    }

    @PostMapping("")
    public ResultModel add(SubjectDTO subjectDTO){
        return subjectService.add(subjectDTO);
    }

    @DeleteMapping("/{id}")
    public ResultModel deleteById(@PathVariable("id") int id){
        return subjectService.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResultModel updateById(@PathVariable("id") int id,String name){
        return subjectService.updateById(id,name);
    }

}

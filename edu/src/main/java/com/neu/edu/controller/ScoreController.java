package com.neu.edu.controller;

import com.neu.edu.dto.ScoreDTO;
import com.neu.edu.dto.StudentDTO;
import com.neu.edu.service.ScoreService;
import com.neu.edu.utils.ResultModel;
import com.neu.edu.vo.ScoreVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scores")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @GetMapping("")
    public ResultModel<List<ScoreVO>> findAll(){
        return scoreService.findAll();
    }

    /**
     * 通过老师id查找该老师的所有学生的成绩
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResultModel<List<ScoreVO>> find(@PathVariable("id") int id){
        return scoreService.find(id);
    }

//    @GetMapping("/{id}")
//    public ResultModel<List<ScoreVO>> findById(){
//        return scoreService.findById();
//    }



    @PutMapping("/{id}")
    public ResultModel updateById(@PathVariable("id") int id, ScoreDTO scoreDTO){
        return scoreService.updateById(scoreDTO);
    }


}

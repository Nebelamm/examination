package com.neu.edu.controller;


import com.neu.edu.dto.ExampaperDTO;
import com.neu.edu.dto.StudentDTO;
import com.neu.edu.service.ExampaperService;
import com.neu.edu.service.StudentService;
import com.neu.edu.utils.ResultModel;
import com.neu.edu.vo.ExampaperVO;
import com.neu.edu.vo.StudentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exampapers")
public class ExampaperController {
    @Autowired
    private ExampaperService exampaperService;

    @GetMapping("/{id}")
    public ResultModel<List<ExampaperVO>> findById(@PathVariable("id") int id){
        return exampaperService.findById(id);
    }

    @PostMapping("")
    public ResultModel add(ExampaperDTO exampaperDTO){
        return exampaperService.add(exampaperDTO);
    }

}

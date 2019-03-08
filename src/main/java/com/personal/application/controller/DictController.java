package com.personal.application.controller;

import com.personal.application.VO.ResultVO;
import com.personal.application.pojo.Dict;
import com.personal.application.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dict")
public class DictController {
    @Autowired
    private DictService dictService;

    @PostMapping("bind")
    public ResultVO getDict(@RequestParam(value = "type") String type){
        ResultVO resultVO = new ResultVO();
        List<Dict> dictList = dictService.getDict(type);
        resultVO.setData(dictList);
        resultVO.setSuccess(true);
        return resultVO;
    }
}









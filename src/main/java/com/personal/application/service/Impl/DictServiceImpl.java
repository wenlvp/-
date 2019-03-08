package com.personal.application.service.Impl;

import com.personal.application.mapper.DictMapper;
import com.personal.application.pojo.Dict;
import com.personal.application.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DictServiceImpl implements DictService {
    @Autowired
    private DictMapper dictMapper;
    @Override
    public List<Dict> getDict(String type) {
        return dictMapper.getDict(type);
    }
}

package com.personal.application.service;

import com.personal.application.pojo.Dict;

import java.util.List;

public interface DictService {
    List<Dict> getDict(String type);
}

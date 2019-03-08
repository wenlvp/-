package com.personal.application.pojo;

import lombok.Data;



@Data
public class Dict {
    private String dictType;
    private String dictTypeName;
    private String dictValue;
    private String dictName;
    private int sort;

    public Dict() {
    }

    public Dict(String dictType, String dictTypeName, String dictValue, String dictName, int sort) {
        this.dictType = dictType;
        this.dictTypeName = dictTypeName;
        this.dictValue = dictValue;
        this.dictName = dictName;
        this.sort = sort;
    }
}

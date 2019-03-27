package com.personal.application.dto;

import lombok.Data;

@Data
public class CountDto {
    private Integer count;
    private Integer flg;

    public CountDto() {
    }

    public CountDto(Integer count, Integer flg) {
        this.count = count;
        this.flg = flg;
    }
}

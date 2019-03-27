package com.personal.application.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CollectionDto {
    private String userId;
    private Integer newsId;
    private Date CreateTime;
    private String title;
    private String userName;
    private Integer newsType;
    private String newsTypeName;
    private Integer startRow;
    private Integer pageSize;
    private Date CreateTimeBefore;
    private Date CreateTimeLate;

    public CollectionDto() {
    }

    public CollectionDto(String userId, Integer newsType, Integer startRow, Integer pageSize) {
        this.userId = userId;
        this.newsType = newsType;
        this.startRow = startRow;
        this.pageSize = pageSize;
    }
}

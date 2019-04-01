package com.personal.application.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class News {
    @Id
    private Integer newsId;
    private String title;
    private Integer newsType;
    private String userId;
    private Date pubTime;
    private String content;
    private Integer readNum;
    private Integer commentNum;
    private Integer agreeNum;
    private String newsPicture;
    private Integer auditFlg;
    private String newsTypeName;

    public News(String title, Integer newsType, String userId,  String content) {
        this.title = title;
        this.newsType = newsType;
        this.userId = userId;
        this.content = content;
    }

    public News() {
    }
}

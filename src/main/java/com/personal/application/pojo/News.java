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
    private String newsPicture;
    private Integer auditFlg;
    private String newsTypeName;
}

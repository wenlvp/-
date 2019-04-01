package com.personal.application.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Notice {
    @Id
    private Integer id;
    private String notifierId;
    private String message;
    private Integer newsId;
    private String createUserId;
    private Integer readFlg;
    private Date createTime;

    private String title;
    private String userName;
    public Notice(String message, Integer newsId, String createUserId) {
        this.message = message;
        this.newsId = newsId;
        this.createUserId = createUserId;
    }

    public Notice() {
    }
}

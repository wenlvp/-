package com.personal.application.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Comment {
    @Id
    private Integer id;
    private Integer newsId;
    private String userId;
    private String comments;
    private Date createTime;

    public Comment(Integer newsId, String userId, String comments) {
        this.newsId = newsId;
        this.userId = userId;
        this.comments = comments;
    }

    public Comment() {
    }
}

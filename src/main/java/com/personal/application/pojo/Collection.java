package com.personal.application.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Collection {
    @Id
    private Integer id;
    private String userId;
    private Integer newsId;
    private Date CreateTime;
}

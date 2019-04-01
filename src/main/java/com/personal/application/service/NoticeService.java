package com.personal.application.service;

import com.personal.application.pojo.Notice;

import java.util.List;

public interface NoticeService {
    List<Notice> findNoticeByUserId(String userId,Integer startRow,Integer pageSize,String flag);

    Integer updateReadFlag(Integer id);
}

package com.personal.application.service.Impl;

import com.personal.application.mapper.NoticeMapper;
import com.personal.application.pojo.Notice;
import com.personal.application.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeImpl implements NoticeService {
    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public List<Notice> findNoticeByUserId(String userId, Integer startRow, Integer pageSize, String flag) {
        return noticeMapper.findNoticeByUserId(userId,startRow,pageSize,flag);
    }

    @Override
    public Integer updateReadFlag(Integer id) {
        return noticeMapper.updateReadFlg(id);
    }
}

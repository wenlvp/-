package com.personal.application.service.Impl;

import com.personal.application.common.Constant;
import com.personal.application.dto.CollectionDto;
import com.personal.application.mapper.CollectionMapper;
import com.personal.application.mapper.NoticeMapper;
import com.personal.application.pojo.Notice;
import com.personal.application.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionImpl implements CollectionService {
    @Autowired
    private NoticeMapper noticeMapper;
    @Autowired
    private CollectionMapper collectionMapper;

    @Override
    public Integer changeCollection(Integer newsId, String userId) {
        Integer successFlg = 0;
        Integer agreeFlg = collectionMapper.getCollectionById(newsId, userId);
        if (agreeFlg == 2){
            successFlg +=  collectionMapper.addCollection(newsId,userId);
            if (successFlg>0){
                noticeMapper.addNotice(new Notice(Constant.NEWS_COMMENT_MSG,newsId,userId));
            }
        }else if(agreeFlg == 0){
            successFlg += collectionMapper.updateCollectFlg(newsId,userId,1);
        }else if(agreeFlg == 1){
            successFlg += collectionMapper.updateCollectFlg(newsId,userId,0);
        }
        if (successFlg>0){
            noticeMapper.addNotice(new Notice(Constant.NEWS_COMMENT_MSG,newsId,userId));
            if (successFlg>0){
                noticeMapper.addNotice(new Notice(Constant.NEWS_AGREE_MSG,newsId,userId));
            }
        }
        return successFlg;
    }

    @Override
    public Integer getIsCollection(Integer newsId, String userId) {
        return collectionMapper.getCollectionById(newsId,userId);
    }

    @Override
    public List<CollectionDto> findCollectionByUserId(CollectionDto dto) {
        return collectionMapper.findCollectionByUserId(dto);
    }
}

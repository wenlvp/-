package com.personal.application.service;

import com.personal.application.dto.CollectionDto;

import java.util.List;

public interface CollectionService {
    Integer changeCollection(Integer newsId,String userId);

    Integer getIsCollection(Integer newsId, String userId);

    List<CollectionDto> findCollectionByUserId(CollectionDto dto);
}

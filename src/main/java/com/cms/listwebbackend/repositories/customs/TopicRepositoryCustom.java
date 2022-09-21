package com.cms.listwebbackend.repositories.customs;

import com.cms.listwebbackend.entities.TopicEntity;
import com.cms.listwebbackend.results.DataTable;

import java.util.HashMap;

public interface TopicRepositoryCustom {
    DataTable<TopicEntity> findByCriteria(HashMap<String, Object> criteria, String[] orderBy, int pageIndex, int pageSize);
}

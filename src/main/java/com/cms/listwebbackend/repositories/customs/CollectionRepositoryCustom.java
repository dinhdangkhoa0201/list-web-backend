package com.cms.listwebbackend.repositories.customs;

import com.cms.listwebbackend.entities.CollectionEntity;
import com.cms.listwebbackend.results.DataTable;

import java.util.HashMap;

public interface CollectionRepositoryCustom {
    DataTable<CollectionEntity> findByCriteria(HashMap<String, Object> criteria, String[] orderBy, int pageIndex, int pageSize);
}

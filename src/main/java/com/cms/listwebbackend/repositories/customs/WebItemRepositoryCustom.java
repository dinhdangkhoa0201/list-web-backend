package com.cms.listwebbackend.repositories.customs;

import com.cms.listwebbackend.entities.WebItemEntity;
import com.cms.listwebbackend.results.DataTable;

import java.util.HashMap;

public interface WebItemRepositoryCustom {
    DataTable<WebItemEntity> findByCriteria(HashMap<String, Object> criteria, String[] orderBy, int pageIndex, int pageSize);
}

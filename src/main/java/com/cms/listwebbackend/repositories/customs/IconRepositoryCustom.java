package com.cms.listwebbackend.repositories.customs;

import com.cms.listwebbackend.entities.IconEntity;
import com.cms.listwebbackend.results.DataTable;

import java.util.HashMap;

public interface IconRepositoryCustom {
    DataTable<IconEntity> findByCriteria(HashMap<String, Object> criteria, String[] orderBy, int pageIndex, int pageSize);
}

package com.cms.listwebbackend.repositories.customs;

import com.cms.listwebbackend.entities.SystemConstantEntity;
import com.cms.listwebbackend.results.DataTable;

import java.util.HashMap;

public interface SystemConstantRepositoryCustom {
    DataTable<SystemConstantEntity> findByCriteria(HashMap<String, Object> criteria, String[] orderBy, int pageIndex, int pageSize);
}

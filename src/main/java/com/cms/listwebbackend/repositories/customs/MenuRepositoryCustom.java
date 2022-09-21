package com.cms.listwebbackend.repositories.customs;

import com.cms.listwebbackend.entities.MenuEntity;
import com.cms.listwebbackend.results.DataTable;

import java.util.HashMap;

public interface MenuRepositoryCustom {
    DataTable<MenuEntity> findByCriteria(HashMap<String, Object> criteria, String[] orderBy, int pageSize, int pageIndex);
}

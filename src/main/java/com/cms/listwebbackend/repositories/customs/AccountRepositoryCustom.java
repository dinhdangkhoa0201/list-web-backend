package com.cms.listwebbackend.repositories.customs;

import com.cms.listwebbackend.entities.AccountEntity;
import com.cms.listwebbackend.results.DataTable;

import java.util.HashMap;

public interface AccountRepositoryCustom {
    DataTable<AccountEntity> findByCriteria(HashMap<String, Object> criteria, String[] orderBy, int pageIndex, int pageSize);
}

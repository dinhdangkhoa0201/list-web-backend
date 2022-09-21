package com.cms.listwebbackend.services;

import com.cms.listwebbackend.models.MenuModel;
import com.cms.listwebbackend.requests.CriteriaRequest;
import com.cms.listwebbackend.requests.MenuRequest;
import com.cms.listwebbackend.results.DataTable;
import com.cms.listwebbackend.results.ObjectResult;

import java.util.HashMap;
import java.util.List;

public interface IMenuService {
    ObjectResult<MenuModel> save(MenuRequest request);

    ObjectResult<MenuModel> update(Long id, MenuRequest request);

    ObjectResult<MenuModel> delete(Long id);

    ObjectResult<MenuModel> findAll();

    DataTable<MenuModel> findByCriteria(CriteriaRequest request);

    ObjectResult<MenuModel> findByCode(String code);

    ObjectResult<Integer> saveByOrder(HashMap<Long, Integer> mapIndexId);
}

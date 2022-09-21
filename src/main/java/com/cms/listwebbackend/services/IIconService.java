package com.cms.listwebbackend.services;

import com.cms.listwebbackend.models.IconModel;
import com.cms.listwebbackend.requests.CriteriaRequest;
import com.cms.listwebbackend.results.DataTable;
import com.cms.listwebbackend.results.ObjectResult;

public interface IIconService {
    DataTable<IconModel> findByCriteria(CriteriaRequest request);

    ObjectResult<IconModel> findAll();
}

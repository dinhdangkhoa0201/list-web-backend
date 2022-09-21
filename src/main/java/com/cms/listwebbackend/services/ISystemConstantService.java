package com.cms.listwebbackend.services;

import com.cms.listwebbackend.models.SystemConstantModel;
import com.cms.listwebbackend.requests.CriteriaRequest;
import com.cms.listwebbackend.requests.SystemConstantRequest;
import com.cms.listwebbackend.results.DataTable;
import com.cms.listwebbackend.results.ObjectResult;

public interface ISystemConstantService {

    ObjectResult<SystemConstantModel> save(SystemConstantRequest request);

    ObjectResult<SystemConstantModel> update(Long id, SystemConstantRequest request);

    ObjectResult<SystemConstantModel> findById(Long id);

    ObjectResult<SystemConstantModel> findAll();

    ObjectResult<SystemConstantModel> delete(Long id);

    DataTable<SystemConstantModel> findByCriteria(CriteriaRequest request);
}

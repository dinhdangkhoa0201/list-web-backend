package com.cms.listwebbackend.services;

import com.cms.listwebbackend.models.CollectionModel;
import com.cms.listwebbackend.requests.CollectionRequest;
import com.cms.listwebbackend.requests.CriteriaRequest;
import com.cms.listwebbackend.results.DataTable;
import com.cms.listwebbackend.results.ObjectResult;

public interface ICollectionService {
    ObjectResult<CollectionModel> save(CollectionRequest request);

    ObjectResult<CollectionModel> update(Long id, CollectionRequest request);

    ObjectResult<CollectionModel> findById(Long id);

    ObjectResult<CollectionModel> findAll();

    DataTable<CollectionModel> findByCriteria(CriteriaRequest request);

    ObjectResult<CollectionModel> delete(Long id);

    ObjectResult<CollectionModel> findByUser(Long userId);
}
